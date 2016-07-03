package it.davideromito.lookup.cache;

import it.davideromito.Tags;
import it.davideromito.lookup.Findable;

import java.util.List;

/**
 * Created by davideromito on 03/07/16.
 */
public interface Cache extends Findable{
    void insert(String elementToSearch, Tags tag, List listOfElement);
}
