package it.davideromito.crawler;

import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.retrieve.page.PagesRetriever;
import it.davideromito.crawler.retrieve.link.Retrieve;
import it.davideromito.crawler.retrieve.link.RetrieveImpl;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by davideromito on 28/06/16.
 */
public class Crawler {
    public static void main(String[] args) throws Exception {

        Retrieve retrieve = new RetrieveImpl();

        String basePage = "http://www.nhs.uk";
        String rootPage = basePage + "/Conditions/Pages/";
        String homepage = rootPage + "hub.aspx";

        Set<String> set = retrieve.retrieveSetOfLinks(homepage, "<a href=\"BodyMap.aspx");

        Set<String> setLink = new HashSet<String>();
        for (String s : set) {
            setLink.addAll(retrieve.retrieveSetOfLinks(rootPage+s, "<a href=\"/conditions" ));
        }

        Set<String> testLink = new HashSet<String>();
        int i=0;
        for (String s : setLink){
            testLink.add(s);
            i++;
            if(i>11){
                break;
            }
        }

        PagesRetriever pr = new PagesRetriever(basePage);
        //Set<Page> pages = pr.retrievePages(setLink);
        Set<Page> pages = pr.retrievePages(testLink);

        System.out.println(pages);
    }
}
