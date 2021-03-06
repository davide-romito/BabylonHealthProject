package it.davideromito.crawler.retrieve.link;

import java.io.IOException;
import java.util.Set;

public interface Retrieve {
    /**
     * Given a page urlPage, retrieve the element corresponding with the pattera
     *
     * @param urlPage
     * @param pattern
     * @return Set of string with the element pattern
     * @throws IOException
     */
    Set<String> retrieveSetOfLinks(String urlPage, String pattern) throws IOException;
}
