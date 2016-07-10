package it.davideromito.crawler.retrieve.link;

import it.davideromito.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RetrieveImpl implements Retrieve {
    /**
     * Given a page urlPage, retrieve the element corresponding with the pattera
     *
     * @param urlPage
     * @param pattern
     * @return Set of string with the element pattern
     * @throws IOException
     */
    public Set<String> retrieveSetOfLinks(String urlPage, String pattern) throws IOException {
        Set<String> linksSet = new HashSet<>();
        URL urlElement = new URL(urlPage);
        BufferedReader in = new BufferedReader(new InputStreamReader(urlElement.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains(pattern)) {
                linksSet.add(retrieveLink(inputLine));
            }
        }
        in.close();
        return linksSet;
    }

    /**
     * Retrieve the link from a line
     *
     * @param line
     * @return url
     */
    protected String retrieveLink(String line) {
        Pattern patternLink = Pattern.compile(Constant.HTML_A_HREF_TAG_PATTERN);
        Matcher matcherLink = patternLink.matcher(line);
        String link = "";
        while (matcherLink.find()) {
            link = matcherLink.group(1);
        }
        return link;
    }
}
