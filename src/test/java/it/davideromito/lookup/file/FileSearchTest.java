package it.davideromito.lookup.file;

import it.davideromito.Tags;
import it.davideromito.lookup.file.FileSearch;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by davideromito on 03/07/16.
 */
public class FileSearchTest {
    private static final String FILE_NAME = "FILE_TEST";
    FileSearch fs;

    @Before
    public void setUp() throws Exception {
        fs = new FileSearch(FILE_NAME);
    }

    @Test
    public void testSearchSingleTag() throws Exception {
        List<String> listResult = fs.search(Tags.DESCRIPTION, "description1");
        assertEquals("{\"url\":\"url1_mock\",\"title\":\"title1_mock\",\"description\":\"description1_mock\",\"keywords\":\"keywords1_mock\"}", listResult.get(0));

        listResult.clear();
        listResult = fs.search(Tags.KEYWORDS, "key");
        assertEquals(3,listResult.size());
        assertEquals("{\"url\":\"url1_mock\",\"title\":\"title1_mock\",\"description\":\"description1_mock\",\"keywords\":\"keywords1_mock\"}", listResult.get(0));
        assertEquals("{\"url\":\"url3_mock\",\"title\":\"mock\",\"description\":\"description3_mock\",\"keywords\":\"keywords3_mock\"}", listResult.get(1));
        assertEquals("{\"url\":\"mock\",\"title\":\"title4_mock\",\"description\":\"description_4mock\",\"keywords\":\"keywords4_mock\"}", listResult.get(2));
    }

    @Test
    public void testSearchMultiTag() throws Exception {
        List<String> listResult = fs.search("string");
        assertEquals("{\"url\":\"string\",\"title\":\"string\",\"description\":\"string\",\"keywords\":\"string\"}", listResult.get(0));

        listResult.clear();
        listResult = fs.search("mock");
        assertEquals(3,listResult.size());
        assertEquals("{\"url\":\"url2_mock\",\"title\":\"title2_mock\",\"description\":\"description2_mock\",\"keywords\":\"mock\"}", listResult.get(0));
        assertEquals("{\"url\":\"url3_mock\",\"title\":\"mock\",\"description\":\"description3_mock\",\"keywords\":\"keywords3_mock\"}", listResult.get(1));
        assertEquals("{\"url\":\"mock\",\"title\":\"title4_mock\",\"description\":\"description_4mock\",\"keywords\":\"keywords4_mock\"}", listResult.get(2));


    }

    @Test
    public void testCreateStringToSearch() throws Exception {
        String elementToSearch = "elementToSearch";
        String tagToSearch = Tags.DESCRIPTION.name();
        String resultString = fs.createStringToSearch(Tags.DESCRIPTION, elementToSearch);
        assertEquals("\"" + tagToSearch + "\":\"" + elementToSearch, resultString);
    }

}