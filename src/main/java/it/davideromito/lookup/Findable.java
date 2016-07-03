package it.davideromito.lookup;

import it.davideromito.Tags;

import java.util.List;

/**
 * Created by davideromito on 03/07/16.
 */
public interface Findable {
    List<String> search(Tags tag, String element);

    List<String> search(String element);
}
