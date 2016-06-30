package it.davideromito.crawler;

import it.davideromito.crawler.converter.JSONConverter;
import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.retrieve.page.PagesRetriever;
import it.davideromito.crawler.retrieve.link.Retrieve;
import it.davideromito.crawler.retrieve.link.RetrieveImpl;
import it.davideromito.crawler.save.FileSave;
import it.davideromito.crawler.save.Save;


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

        System.out.println("START RETRIEVE link from HOMEPAGE");
        Set<String> set = retrieve.retrieveSetOfLinks(homepage, "<a href=\"BodyMap.aspx");
        System.out.println("END RETRIEVE link from HOMEPAGE");

        System.out.println("START RETRIEVE link from VARIOUS PAGES");
        Set<String> setLink = new HashSet<String>();
        for (String s : set) {
            setLink.addAll(retrieve.retrieveSetOfLinks(rootPage+s, "<a href=\"/conditions" ));
        }
        System.out.println("END RETRIEVE link from VARIOUS PAGES");

        System.out.println("START RETRIEVE INFORMATION from VARIOUS PAGES");
        PagesRetriever pr = new PagesRetriever(basePage);
        Set<Page> pages = pr.retrievePages(setLink);
        System.out.println("END RETRIEVE INFORMATION from VARIOUS PAGES");

        System.out.println("START SAVE PHASE");
        Save save = new FileSave("CRAWLER");
        save.saveSet(JSONConverter.toJSON(pages));
        System.out.println("END SAVE PHASE");


    }
}
