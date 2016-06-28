package it.davideromito.crawler.retrieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by davideromito on 28/06/16.
 */
public class RetrieveImpl implements Retrieve{
    private final static String HTML_A_HREF_TAG_PATTERN = "href=\"(.*?)\"";


    public Set<String> retrieveSetOfLinks(String urlPage, String pattern) throws IOException {
        Set<String> linksSet = new HashSet<String>();
        URL urlElement = new URL(urlPage);
        BufferedReader in = new BufferedReader(new InputStreamReader(urlElement.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains(pattern)) {
                linksSet.add(retrieveLink(inputLine));
            }
        }
        in.close();
        return  linksSet;
    }

    private String retrieveLink(String line) {
        Pattern patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
        Matcher matcherLink = patternLink.matcher(line);
        String link = "";
        while (matcherLink.find()) {
            link = matcherLink.group(1);
        }
        return link;
    }
}
