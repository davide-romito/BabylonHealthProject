package it.davideromito.lookup.cache;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class CacheOperationImplTest {
    private CacheOperationImpl coi;

    @Before
    public void setUp() throws Exception {
        coi = new CacheOperationImpl();
    }

    @Test
    public void populateMap() throws Exception {
        String line = "{\"url\":\"http://www.nhs.uk/conditions/Arthroscopy\",\"title\":\"Arthroscopy - NHS Choices\",\"description\":\"An arthroscopy is a type of keyhole surgery used both to diagnose and treat problems with joints. It\\u0027s most commonly used on the knees, ankles, shoulders, elbows, wrists and hips.\",\"keywords\":\"National Health Service (NHS),Arthroscopy\",\"dc\":{\"title\":\"Arthroscopy - NHS Choices\",\"description\":\"An arthroscopy is a type of keyhole surgery used both to diagnose and treat problems with joints. It\\u0027s most commonly used on the knees, ankles, shoulders, elbows, wrists and hips.\",\"subject\":\"National Health Service (NHS),Arthroscopy\",\"dateIssued\":\"2015-05-06\",\"coverage\":\"England\",\"creator\":\"NHS Choices\",\"format\":\"text/html\",\"language\":\"eng\",\"identifier\":\"http://www.nhs.uk\",\"publisher\":\"Department of Health\",\"rights\":\"http://www.nhs.uk/termsandconditions/Pages/TermsConditions.aspx\"},\"egms\":{\"accessibility\":\"Double-A\"},\"wt\":{\"ti\":\"Arthroscopy - NHS Choices\",\"cgN\":\"Treatments and Conditions\",\"cgS\":\"Arthroscopy\",\"sv\":\"CH-D-WEB01\"},\"dcSext\":{\"realUrl\":\"/conditions/arthroscopy/Pages/Introduction.aspx\",\"server\":\"CH-D-WEB01\",\"bmSection1\":\"Treatments and Conditions\",\"bmSection2\":\"Arthroscopy\",\"bmSection3\":\"Arthroscopy\"}}";
        Map<String, Set<String>> expected = new HashMap<>();
        Set<String> set = new TreeSet<>();
        set.add(line);
        expected.put("national", set);
        expected.put("health", set);
        expected.put("service", set);
        expected.put("nhs", set);
        expected.put("arthroscopy", set);

        Map<String, Set<String>> map = new HashMap<>();
        String value = "National Health Service (NHS),Arthroscopy";
        coi.populateMap(map, line, value);
        assertEquals(expected, map);
    }

}