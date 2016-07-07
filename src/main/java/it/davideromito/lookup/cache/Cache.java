package it.davideromito.lookup.cache;

import it.davideromito.Tags;
import it.davideromito.lookup.Findable;

import java.util.Set;

public interface Cache extends Findable {
    /**
     * Insert with the key elementToSearch the set of listOfElement in the cache tag
     *
     * @param elementToSearch element to search
     * @param tag             key of the search
     * @param listOfElement   set of element to add in the cache
     */
    void insert(String elementToSearch, Tags tag, Set listOfElement);
}
