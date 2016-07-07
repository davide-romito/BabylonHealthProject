package it.davideromito.lookup;

import it.davideromito.Tags;

import java.util.List;
import java.util.Set;

/**
 * Created by davideromito on 03/07/16.
 */
public interface Findable {
    Set<String> search(Tags tag, String element);

    Set<String> search(String element);
}
