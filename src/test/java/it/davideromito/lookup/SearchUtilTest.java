package it.davideromito.lookup;

import it.davideromito.Tags;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by davideromito on 09/07/16.
 */
public class SearchUtilTest {


    @Test
    public void searchValue() throws Exception {
        String line = "{\"url\":\"http://www.nhs.uk/conditions/Headache\",\"title\":\"Headaches - NHS Choices\",\"description\":\"Read about some of the main types of headaches, and find out when you should seek medical advice.\",\"keywords\":\"National Health Service (NHS),Headache\",\"dc\":{\"title\":\"Headaches - NHS Choices\",\"description\":\"Read about some of the main types of headaches, and find out when you should seek medical advice.\",\"subject\":\"National Health Service (NHS),Headache\",\"dateIssued\":\"2016-02-06\",\"coverage\":\"England\",\"creator\":\"NHS Choices\",\"format\":\"text/html\",\"language\":\"eng\",\"identifier\":\"http://www.nhs.uk\",\"publisher\":\"Department of Health\",\"rights\":\"http://www.nhs.uk/termsandconditions/Pages/TermsConditions.aspx\"},\"egms\":{\"accessibility\":\"Double-A\"},\"wt\":{\"ti\":\"Headaches - NHS Choices\",\"cgN\":\"Treatments and Conditions\",\"cgS\":\"Headaches\",\"sv\":\"CH-D-WEB02\"},\"dcSext\":{\"realUrl\":\"/conditions/headache/Pages/Introduction.aspx\",\"server\":\"CH-D-WEB02\",\"bmSection1\":\"Treatments and Conditions\",\"bmSection2\":\"Headaches\",\"bmSection3\":\"Headaches\"}}";
        Set<String> expectedSet = new TreeSet<>();
        expectedSet.add(line);
        Set<String> output = new TreeSet<>();
        SearchUtil.searchValue(Tags.TITLE, output, "stomac", line);
        assertTrue(output.isEmpty());

        output = new TreeSet<>();
        SearchUtil.searchValue(Tags.TITLE, output, "head", line);
        assertEquals(expectedSet, output);

        output = new TreeSet<>();
        SearchUtil.searchValue(Tags.DESCRIPTION, output, "bout", line);
        assertTrue(output.isEmpty());

        output = new TreeSet<>();
        SearchUtil.searchValue(Tags.KEYWORDS, output, "nhs", line);
        assertEquals(expectedSet, output);
    }

}