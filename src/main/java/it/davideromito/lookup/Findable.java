package it.davideromito.lookup;

import it.davideromito.Tags;

import java.util.Set;

public interface Findable {
    /**
     * Search the element in the cache saved with the key tag
     *
     * @param tag
     * @param element
     * @return
     */
    Set<String> search(Tags tag, String element);

    /**
     * Search the element in the whole cache
     *
     * @param element
     * @return set of strings
     */
    Set<String> search(String element);
}
