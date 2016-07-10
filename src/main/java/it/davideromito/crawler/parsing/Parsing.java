package it.davideromito.crawler.parsing;

import it.davideromito.model.Page;

import java.io.IOException;

public interface Parsing {
    /**
     * given an URl, retrieve the element of the page and create and object Page
     * @param url
     * @return the object Page with all the elemnt retrieved from the url
     * @throws IOException
     */
    Page retrievePage(String url) throws IOException;
}
