package it.davideromito.crawler;

import it.davideromito.Constant;
import it.davideromito.crawler.converter.JSONConverter;
import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.retrieve.page.PagesRetriever;
import it.davideromito.crawler.retrieve.link.Retrieve;
import it.davideromito.crawler.retrieve.link.RetrieveImpl;
import it.davideromito.crawler.save.FileSave;
import it.davideromito.crawler.save.Save;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by davideromito on 28/06/16.
 */
public class Crawler {
    public void generateKnowledge(){
        long start = System.nanoTime();
        Set<Page> pages = extractInformations();
        saveInformations(pages);
        System.out.println("Knowledge generation in "+((System.nanoTime()-start)/Math.pow(10,9))+ " seconds");
    }


    protected Set<Page> extractInformations(){
        Retrieve retrieve = new RetrieveImpl();

        System.out.println("START RETRIEVE link from HOMEPAGE");
        Set<String> set = new HashSet<String>();
        try {
            set = retrieve.retrieveSetOfLinks(Constant.HOMEPAGE, "<a href=\"BodyMap.aspx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("END RETRIEVE link from HOMEPAGE");

        System.out.println("START RETRIEVE link from VARIOUS PAGES");
        Set<String> setLink = new HashSet<String>();
        for (String s : set) {
            try {
                setLink.addAll(retrieve.retrieveSetOfLinks(Constant.ROOT_PAGE+s, "<a href=\"/conditions" ));
            } catch (IOException e) {
                System.out.println(Constant.ROOT_PAGE+s);
                e.printStackTrace();
            }
        }
        System.out.println("END RETRIEVE link from VARIOUS PAGES");

        System.out.println("START RETRIEVE INFORMATION from VARIOUS PAGES");
        PagesRetriever pr = new PagesRetriever(Constant.BASE_PAGE);
        Set<Page> pages = pr.retrievePages(setLink);
        System.out.println("END RETRIEVE INFORMATION from VARIOUS PAGES");
        return pages;
    }

    protected void saveInformations(Set pages){
        System.out.println("START SAVE PHASE");
        Save save;
        try {
            save = new FileSave(Constant.FILE_NAME);
            save.saveSet(JSONConverter.toJSON(pages));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("END SAVE PHASE");
    }

    public static void main(String[] args) {
        Crawler c = new Crawler();
        c.generateKnowledge();
    }
}
