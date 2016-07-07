package it.davideromito.lookup;

import it.davideromito.Constant;
import it.davideromito.Tags;
import it.davideromito.lookup.cache.Cache;
import it.davideromito.lookup.cache.CacheSearch;
import it.davideromito.lookup.file.FileSearch;

import java.util.Set;
import java.util.TreeSet;

public class Search {
    private String file;

    public Search() {
        this.file = Constant.FILE_NAME;
    }

    public Search(String file) {
        this.file = file;
    }

    public Set<String> performSearch(String element, Tags tag) {
        Cache cache = new CacheSearch();
        Set<String> result = new TreeSet<>();
        if (cache.hasElement(tag, element) || cache.hasSubElement(tag, element)) {
            result.addAll(cache.search(tag, element));
        } else {
            Findable findOnFile = new FileSearch(file);
            result.addAll(findOnFile.search(tag, element));
            cache.insert(element, tag, result);
        }
        return result;
    }

}
