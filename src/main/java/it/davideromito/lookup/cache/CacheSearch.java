package it.davideromito.lookup.cache;

import com.google.common.cache.LoadingCache;
import it.davideromito.Tags;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by dromito on 05/07/2016.
 */
public class CacheSearch {
    public void insert(String elementToSearch, Tags tag, List listOfElement) {
        //TODO
    }

    public List<String> search(Tags tag, String element) {
        Set<String> strings = new TreeSet<String>();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            strings = retrievePrefix(tagCache, element);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<String>(strings);
    }

    public List<String> search(String element) {
        Set<String> strings = new TreeSet<String>();
        try {
            LoadingCache<Tags, LoadingCache<String, Set<String>>> cache = CacheImpl.getInstance().getCache();
            for (Tags tag : Tags.values()) {
                LoadingCache<String, Set<String>> stringSetLoadingCache = cache.get(tag);
                strings.addAll(retrievePrefix(stringSetLoadingCache, element));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<String>(strings);
    }

    private Set<String> retrievePrefix(LoadingCache<String, Set<String>> cache, String element)
            throws ExecutionException {
        Set<String> output = new TreeSet<String>();
        for (String s : cache.asMap().keySet()) {
            if (s.startsWith(element)) {
                output.addAll(cache.get(s));
            }
        }
        return output;
    }
}
