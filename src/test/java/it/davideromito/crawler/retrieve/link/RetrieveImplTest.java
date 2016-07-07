package it.davideromito.crawler.retrieve.link;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetrieveImplTest {
    private RetrieveImpl ri;

    @Before
    public void setUp() throws Exception {
        ri = new RetrieveImpl();
    }

    @Test
    public void retrieveLink() throws Exception {
        assertEquals("", ri.retrieveLink("test"));
        assertEquals("BodyMap.aspx?Index=H", ri.retrieveLink("<a href=\"BodyMap.aspx?Index=H\">"));
        assertEquals("/conditions/Flu", ri.retrieveLink("<a href=\"/conditions/Flu\">Flu </a>"));
    }

}