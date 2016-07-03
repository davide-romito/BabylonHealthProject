package it.davideromito.lookup.file;

import it.davideromito.Tags;
import it.davideromito.lookup.Findable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearch implements Findable {
    private static final String APOS = "\"";
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
    public List<String> search(Tags tag, String element) {
        List<String> output = new ArrayList<String>();
        String strToSearch = createStringToSearch(tag, element);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(strToSearch.toLowerCase())) {
                    output.add(line);
                }
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
    public List<String> search(String element) {
        List<String> output = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                for (Tags tag : Tags.values()) {
                    String strToSearch = createStringToSearch(tag, element);
                    if (line.toLowerCase().contains(strToSearch.toLowerCase())) {
                        output.add(line);
                        break;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Create the string in the form :
     * "tag":"element
     *
     * @param tag     string
     * @param element string
     * @return a string in the form "tag":"element
     */
    protected String createStringToSearch(Tags tag, String element) {
        StringBuilder sb = new StringBuilder();
        sb.append(APOS).append(tag.name()).append(APOS);
        sb.append(":");
        sb.append(APOS).append(element);
        return sb.toString();
    }
}
