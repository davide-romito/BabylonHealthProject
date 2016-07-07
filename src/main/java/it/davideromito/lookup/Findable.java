package it.davideromito.lookup;

import it.davideromito.Tags;

import java.util.Set;

public interface Findable {
    Set<String> search(Tags tag, String element);

    Set<String> search(String element);
}
