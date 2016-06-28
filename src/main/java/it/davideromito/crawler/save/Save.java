package it.davideromito.crawler.save;

import java.util.Set;

/**
 * Created by davideromito on 28/06/16.
 */
public interface Save {
    void saveSet(Set<String> setOfString);
    void saveString(String string);
}
