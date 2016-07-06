package it.davideromito.lookup.cache;

/**
 * Created by davideromito on 06/07/16.
 */
public interface CacheOperation {
    void invalidate();

    void populate();
}
