package it.davideromito.crawler;

import it.davideromito.crawler.converter.JSONConverter;
import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.parsing.Parsing;
import it.davideromito.crawler.parsing.jsoup.JsoupParsing;
import it.davideromito.crawler.retrieve.Retrieve;
import it.davideromito.crawler.retrieve.RetrieveImpl;


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


        Parsing parse = new JsoupParsing();
        Set<Page> setPage = new HashSet<Page>();
        for (String s : setLink){
            Page p = parse.retrievePage(basePage+s);
            System.out.println(p);
            System.out.println(JSONConverter.toJSON(p));
            setPage.add(p);
        }

    }
}
