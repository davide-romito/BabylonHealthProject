package it.davideromito.crawler.parsing;

import it.davideromito.crawler.model.Page;

import java.io.IOException;

/**
 * Created by davideromito on 28/06/16.
 */
public interface Parsing {
    Page retrievePage(String url) throws IOException;
}
