package it.davideromito.lookup.cache;

public interface CacheOperation {
    /**
     * Remove all the elements from the cache
     */
    void invalidate();

    /**
     * Populate the Cache with all the element in the file
     */
    void populate();
}
