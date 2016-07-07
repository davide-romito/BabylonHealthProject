package it.davideromito.lookup.cache;

import com.google.common.cache.LoadingCache;
import it.davideromito.Tags;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by dromito on 05/07/2016.
 */
public class CacheSearch implements Cache{
    public void insert(String elementToSearch, Tags tag, Set listOfElement) {
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            tagCache.put(elementToSearch.toLowerCase(), listOfElement);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Set<String> search(Tags tag, String element) {
        Set<String> strings = new TreeSet<>();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            strings.addAll(tagCache.get(element));
            if (strings.isEmpty()){
                strings = retrievePrefix(tagCache, element);
                //TODO scrematura
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new TreeSet<>(strings);
    }

    public Set<String> search(String element) {
        Set<String> strings = new TreeSet<>();
        try {
            LoadingCache<Tags, LoadingCache<String, Set<String>>> cache = CacheImpl.getInstance().getCache();
            for (Tags tag : Tags.values()) {
                LoadingCache<String, Set<String>> stringSetLoadingCache = cache.get(tag);
                //TODO change this based on the previous one
                strings.addAll(retrievePrefix(stringSetLoadingCache, element));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new TreeSet<>(strings);
    }

    private Set<String> retrievePrefix(LoadingCache<String, Set<String>> cache, String element)
            throws ExecutionException {
        Set<String> output = new TreeSet<>();
        for (String s : cache.asMap().keySet()) {
            if (element.toLowerCase().startsWith(s)) {
                output.addAll(cache.get(s));
            }
        }
        return output;
    }

    public Boolean hasElement(Tags tag, String element){
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

    public Boolean hasSubElement(Tags tag, String element){
        boolean b = false;
        element = element.toLowerCase();
        try {
            LoadingCache<String, Set<String>> tagCache = CacheImpl.getInstance().getTagCache(tag);
            for (int i = 1; i < element.length(); i++) {
                b = tagCache.asMap().containsKey(element.substring(0,i));
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
