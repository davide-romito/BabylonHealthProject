package it.davideromito.crawler;

import it.davideromito.Constant;
import it.davideromito.converter.JSONConverter;
import it.davideromito.model.Page;
import it.davideromito.crawler.retrieve.page.PagesRetriever;
import it.davideromito.crawler.retrieve.link.Retrieve;
import it.davideromito.crawler.retrieve.link.RetrieveImpl;
import it.davideromito.crawler.save.FileSave;
import it.davideromito.crawler.save.Save;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Crawler {
    /**
     * This method extract the informations from the pages, and then save this information in a file
     */
    public void generateKnowledge() {
        long start = System.nanoTime();
        Set<Page> pages = extractInformations();
        saveInformations(pages);
        System.out.println("Knowledge generation in " + ((System.nanoTime() - start) / Math.pow(10, 9)) + " seconds");
    }


    protected Set<Page> extractInformations() {
        Retrieve retrieve = new RetrieveImpl();

        Set<String> set = new HashSet<>();
        try {
            set = retrieve.retrieveSetOfLinks(Constant.HOMEPAGE, Constant.HREF_BODYMAP);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> setLink = new HashSet<>();
        for (String s : set) {
            try {
                setLink.addAll(retrieve.retrieveSetOfLinks(Constant.ROOT_PAGE + s, Constant.HREF_CONDITIONS));
            } catch (IOException e) {
                System.out.println(Constant.ROOT_PAGE + s);
                e.printStackTrace();
            }
        }

        PagesRetriever pr = new PagesRetriever(Constant.BASE_PAGE);
        return pr.retrievePages(setLink);
    }

    protected void saveInformations(Set pages) {
        Save save;
        try {
            save = new FileSave(Constant.FILE_NAME);
            save.saveSet(JSONConverter.toJSON(pages));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
