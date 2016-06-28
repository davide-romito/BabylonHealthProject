package it.davideromito.crawler.retrieve.page;

import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.parsing.Parsing;
import it.davideromito.crawler.parsing.jsoup.JsoupParsing;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Callable class to retrieve and parse the html pages
 */
class PageRetrieverCallable implements Callable {

    private String url;

    public PageRetrieverCallable(String url) {
        this.url = url;
    }

    public Page call() throws IOException {
        Parsing parse = new JsoupParsing();
        Page p = parse.retrievePage(url);
        return p;
    }
}