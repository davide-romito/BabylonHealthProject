package it.davideromito.crawler.retrieve.link;

import java.io.IOException;
import java.util.Set;

public interface Retrieve {
    Set<String> retrieveSetOfLinks(String urlPage, String pattern) throws IOException;
}
