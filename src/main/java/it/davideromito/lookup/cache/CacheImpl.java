package it.davideromito.lookup.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import it.davideromito.Tags;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Cache class using the Guava lib and Singleton as design pattern
 */
public class CacheImpl {
    private static CacheImpl instance = null;
    private LoadingCache<Tags, LoadingCache<String, Set<String>>> cache;

    private CacheImpl() {
        cache = CacheBuilder.newBuilder().build(
                new CacheLoader<Tags, LoadingCache<String, Set<String>>>() {
                    public LoadingCache<String, Set<String>> load(Tags tag) throws Exception {
                        return CacheBuilder.newBuilder().maximumSize(Tags.values().length)
                                .refreshAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Set<String>>() {
                                    public Set<String> load(String s) throws Exception {
                                        return new TreeSet<>();
                                    }
                                });
                    }
                });

        for (Tags tag : Tags.values()) {
            LoadingCache<String, Set<String>> inCache = CacheBuilder.newBuilder().maximumSize(100000)
                    .refreshAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Set<String>>() {
                        public Set<String> load(String s) throws Exception {
                            return new TreeSet<>();
                        }
                    });
            this.cache.put(tag, inCache);
        }
    }

    public static CacheImpl getInstance() {
        if (instance == null) {
            synchronized (CacheImpl.class) {
                if (instance == null) {
                    instance = new CacheImpl();
                }
            }
        }
        return instance;
    }

    public LoadingCache<Tags, LoadingCache<String, Set<String>>> getCache() {
        return cache;
    }

    public LoadingCache<String, Set<String>> getTagCache(Tags tag) throws ExecutionException {
        return cache.get(tag);
    }
}
