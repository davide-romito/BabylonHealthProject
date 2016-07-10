package it.davideromito.crawler.save;

import java.io.IOException;
import java.util.Set;

public interface Save {
    /**
     * Save in the File file the set of strings passed as parameter
     * @param setOfString set of string to save
     * @throws IOException
     */
    void saveSet(Set<String> setOfString) throws IOException;

    /**
     * Save in the File file the string passed as parameter
     * @param string string to save
     * @throws IOException
     */
    void saveString(String string) throws IOException;
}
