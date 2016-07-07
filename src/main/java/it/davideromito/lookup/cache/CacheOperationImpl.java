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

public class CacheOperationImpl implements CacheOperation {
    public void invalidate() {
        CacheImpl.getInstance().getCache().invalidateAll();
    }

    public void populate() {
        PageFactory pf = new PageFactory();
        for (Tags tag : Tags.values()) {
            Map<String, Set<String>> inMap = new HashMap<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(Constant.FILE_NAME));
                String line;
                while ((line = br.readLine()) != null) {
                    Page s = JSONConverter.fromJson(line, Page.class);
                    String value = pf.returnTagValue(s, tag);
                    populateMap(inMap, line, value);
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

    protected void populateMap(Map<String, Set<String>> inMap, String line, String value) {
        for (String wordOfValues : value.split("[\\p{Space}\\p{Punct}]")) {
            if (wordOfValues.trim().length() > 0) {
                wordOfValues = wordOfValues.toLowerCase();
                Set<String> set;
                if (inMap.containsKey(wordOfValues)) {
                    set = inMap.get(wordOfValues);
                } else {
                    set = new TreeSet<>();
                }
                set.add(line);
                inMap.put(wordOfValues, set);
            }
        }
    }
}
