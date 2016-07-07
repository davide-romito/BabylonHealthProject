package it.davideromito.crawler.parsing;

import it.davideromito.model.Page;

import java.io.IOException;

public interface Parsing {
    Page retrievePage(String url) throws IOException;
}
