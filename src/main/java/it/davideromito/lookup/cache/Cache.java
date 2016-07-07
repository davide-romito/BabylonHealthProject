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

    /**
     * Check if the element is already as key in the cache defined with the key tag
     *
     * @param tag
     * @param element
     * @return true if present, false if not
     */
    Boolean hasElement(Tags tag, String element);

    /**
     * Check if the sub element is already as key in the cache defined with the key tag
     *
     * @param tag
     * @param element
     * @return true if present, false if not
     */
    Boolean hasSubElement(Tags tag, String element);
}
