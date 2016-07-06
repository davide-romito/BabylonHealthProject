package it.davideromito.lookup.cache;

import it.davideromito.Constant;
import it.davideromito.Tags;
import it.davideromito.converter.JSONConverter;
import it.davideromito.model.Page;
import it.davideromito.model.PageFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;

/**
 * Created by davideromito on 06/07/16.
 */
public class CacheOperationImpl implements CacheOperation{
    public void invalidate() {
        CacheImpl.getInstance().getCache().invalidateAll();
    }

    public void populate() {
        PageFactory pf = new PageFactory();
        for (Tags tag : Tags.values()){
            Map<String, Set<String>> inMap = new HashMap<String, Set<String>>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(Constant.FILE_NAME));
                String line;
                while ((line = br.readLine()) != null) {
                    Page s = JSONConverter.fromJson(line, Page.class);
                    String value = pf.returnTagValue(s, tag);
                    for (String wordOfValues: value.split(" ")){//TODO to modify
                        wordOfValues = wordOfValues.toLowerCase();
                        Set<String> set;
                        if (inMap.containsKey(wordOfValues)){
                            set = inMap.get(wordOfValues);
                        }else {
                            set = new TreeSet<String>();
                        }
                        set.add(line);
                        inMap.put(wordOfValues, set);
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                CacheImpl.getInstance().getTagCache(tag).putAll(inMap);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
