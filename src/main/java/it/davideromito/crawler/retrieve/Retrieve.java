package it.davideromito.crawler.retrieve;

import java.io.IOException;
import java.util.Set;

/**
 * Created by davideromito on 28/06/16.
 */
public interface Retrieve {
    Set<String> retrieveSetOfLinks(String urlPage, String pattern) throws IOException;
}
