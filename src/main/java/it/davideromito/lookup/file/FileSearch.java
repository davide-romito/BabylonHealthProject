package it.davideromito.lookup.file;

import it.davideromito.Tags;
import it.davideromito.converter.JSONConverter;
import it.davideromito.lookup.Findable;
import it.davideromito.lookup.SearchUtil;
import it.davideromito.model.Page;
import it.davideromito.model.PageFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class FileSearch implements Findable {
    private String file;

    public FileSearch(String file) {
        this.file = file;
    }

    /**
     * Search the element passed as parameter only in the tag specified
     *
     * @param tag     Tags
     * @param element element to search
     * @return list of string
     * @throws FileNotFoundException
     */
    public Set<String> search(Tags tag, String element) {
        Set<String> output = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                SearchUtil.searchValue(tag, output, element, line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Search in all the element of the string
     *
     * @param element element to search
     * @return list of elements
     * @throws FileNotFoundException
     */
    public Set<String> search(String element) {
        Set<String> output = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                for (Tags tag : Tags.values()) {
                    SearchUtil.searchValue(tag, output, element, line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

}
