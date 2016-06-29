package it.davideromito.crawler.save;

import java.io.IOException;
import java.util.Set;

public interface Save {
    void saveSet(Set<String> setOfString) throws IOException;
    void saveString(String string) throws IOException;
}
