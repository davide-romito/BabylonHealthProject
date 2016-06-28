package it.davideromito.crawler.parsing.jsoup;

import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.parsing.Parsing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by davideromito on 28/06/16.
 */
public class JsoupParsing implements Parsing {
    private static final String NAME = "name";
    private static final String CONTENT = "content";

    public Page retrievePage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Page page = new Page(url);
        page.setTitle(doc.title());
        page.setDescription(doc.getElementsByAttributeValue(NAME,"description").attr(CONTENT));
        page.setKeywords(doc.getElementsByAttributeValue(NAME,"keywords").attr(CONTENT));
        page.setDcTitle(doc.getElementsByAttributeValue(NAME,"DC.title").attr(CONTENT));
        page.setDcDescription(doc.getElementsByAttributeValue(NAME,"DC.description").attr(CONTENT));
        //TODO extend
        return page;
    }
}
