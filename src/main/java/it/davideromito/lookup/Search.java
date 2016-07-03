package it.davideromito.lookup;

import it.davideromito.Tags;
import it.davideromito.lookup.cache.Cache;
import it.davideromito.lookup.cache.CacheSearch;
import it.davideromito.lookup.file.FileSearch;

import java.util.List;

/**
 * Created by davideromito on 03/07/16.
 */
public class Search {
    private String file;

    public Search(String file){
        this.file = file;
    }

    public List<String> performSearch(String element, Tags tag){
        Cache cache = new CacheSearch();
        List<String> result = cache.search(tag, element);
        if (result.isEmpty()) {
            Findable findOnFile = new FileSearch(file);
            result = findOnFile.search(tag, element);
            cache.insert(element,tag,result);
        }
        return result;
    }

}
