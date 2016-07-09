package it.davideromito.lookup.cache;

import com.google.common.cache.LoadingCache;
import it.davideromito.Tags;
import it.davideromito.lookup.SearchUtil;
import it.davideromito.lookup.file.FileSearch;

import java.util.*;
import java.util.concurrent.ExecutionException;


public class CacheSearch implements Cache {
    public void insert(String elementToSearch, Tags tag, Set listOfElement) {
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            tagCache.put(elementToSearch.toLowerCase(), listOfElement);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Set<String> search(Tags tag, String element) {
        return retrieveFromCache(tag, element);
    }

    private Set<String> retrieveFromCache(Tags tag, String element) {
        Set<String> strings = new TreeSet<>();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            strings.addAll(tagCache.get(element));
            if (strings.isEmpty()) {
                strings = retrievePrefix(tag, tagCache, element);
                insert(element, tag, strings);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public Set<String> search(String element) {
        Set<String> strings = new TreeSet<>();
        for (Tags tag : Tags.values()) {
            strings.addAll(retrieveFromCache(tag, element));
        }
        return strings;
    }

    private Set<String> retrievePrefix(Tags tag, LoadingCache<String, Set<String>> cache, String element)
            throws ExecutionException {
        Set<String> output = new TreeSet<>();
        for (String s : cache.asMap().keySet()) {
            if (element.toLowerCase().startsWith(s)) {
                Set<String> strings = cache.get(s);
                for (String string : strings) {
                    SearchUtil.searchValue(tag, output, element, string);
                }
            }
        }
        return output;
    }

    public Boolean hasElement(Tags tag, String element) {
        boolean b = false;
        element = element.toLowerCase();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            b = tagCache.asMap().containsKey(element);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return b;
    }

    public Boolean hasSubElement(Tags tag, String element) {
        boolean b = false;
        element = element.toLowerCase();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            for (int i = 1; i < element.length(); i++) {
                b = tagCache.asMap().containsKey(element.substring(0, i));
                if (b) {
                    break;
                }
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return b;
    }

}
