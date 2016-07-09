package it.davideromito.lookup;

import it.davideromito.Tags;
import it.davideromito.converter.JSONConverter;
import it.davideromito.model.Page;
import it.davideromito.model.PageFactory;

import java.util.Set;

public class SearchUtil {
    private static final String SPACE = " ";

    /**
     * Check in the tag of the opject page if the strToSearch is present. In case add the line to the
     * set output
     *
     * @param tag
     * @param output
     * @param strToSearch
     * @param line
     */
    public static void searchValue(Tags tag, Set<String> output, String strToSearch, String line) {
        Page page = JSONConverter.fromJson(line, Page.class);
        String tagValue = PageFactory.returnTagValue(page, tag);
        if (tagValue != null) {
            tagValue = tagValue.replaceAll("\\p{Punct}", SPACE);
            if (tagValue.toLowerCase().contains(SPACE + strToSearch.toLowerCase()) ||
                    tagValue.toLowerCase().startsWith(strToSearch.toLowerCase())) {
                output.add(line);
            }
        }
    }
}
