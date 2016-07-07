package it.davideromito.lookup.file;

import it.davideromito.Tags;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class FileSearchTest {
    private static final String FILE_NAME = "FILE_TEST";
    FileSearch fs;

    @Before
    public void setUp() throws Exception {
        fs = new FileSearch(FILE_NAME);
    }

    @Test
    public void testSearchSingleTag() throws Exception {
        Set<String> listResult = fs.search(Tags.DESCRIPTION, "description1");
        assertTrue(listResult.contains("{\"url\":\"url1_mock\",\"title\":\"title1_mock\",\"description\":\"description1_mock\",\"keywords\":\"keywords1_mock\"}"));

        listResult.clear();
        listResult = fs.search(Tags.KEYWORDS, "key");
        assertEquals(3, listResult.size());
        assertTrue(listResult.contains("{\"url\":\"url1_mock\",\"title\":\"title1_mock\",\"description\":\"description1_mock\",\"keywords\":\"keywords1_mock\"}"));
        assertTrue(listResult.contains("{\"url\":\"url3_mock\",\"title\":\"mock\",\"description\":\"description3_mock\",\"keywords\":\"keywords3_mock\"}"));
        assertTrue(listResult.contains("{\"url\":\"mock\",\"title\":\"title4_mock\",\"description\":\"description_4mock\",\"keywords\":\"keywords4_mock\"}"));
    }

    @Test
    public void testSearchMultiTag() throws Exception {
        Set<String> listResult = fs.search("string");
        assertTrue(listResult.contains("{\"url\":\"string\",\"title\":\"string\",\"description\":\"string\",\"keywords\":\"string\"}"));

        listResult.clear();
        listResult = fs.search("mock");
        assertEquals(4, listResult.size());
        assertTrue(listResult.contains("{\"url\":\"url1_mock\",\"title\":\"title1_mock\",\"description\":\"description1_mock\",\"keywords\":\"keywords1_mock\"}"));
        assertTrue(listResult.contains("{\"url\":\"url2_mock\",\"title\":\"title2_mock\",\"description\":\"description2_mock\",\"keywords\":\"mock\"}"));
        assertTrue(listResult.contains("{\"url\":\"url3_mock\",\"title\":\"mock\",\"description\":\"description3_mock\",\"keywords\":\"keywords3_mock\"}"));
        assertTrue(listResult.contains("{\"url\":\"mock\",\"title\":\"title4_mock\",\"description\":\"description_4mock\",\"keywords\":\"keywords4_mock\"}"));


    }

}