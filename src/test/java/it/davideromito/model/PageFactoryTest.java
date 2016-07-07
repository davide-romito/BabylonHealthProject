package it.davideromito.model;

import it.davideromito.Tags;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageFactoryTest {
    private Page p;
    private static final String URL = "URL";
    private static final String TITLE = "TITLE";
    private static final String KEYWORDS = "KEYWORDS";
    private static final String DESCRIPTION = "DESCRIPTION";

    @Before
    public void setUp() throws Exception {
        p = new Page();
        p.setUrl(URL);
        p.setTitle(TITLE);
        p.setKeywords(KEYWORDS);
        p.getDc().setDescription(DESCRIPTION);
    }

    @Test
    public void returnTagValue() throws Exception {
        assertEquals(URL, PageFactory.returnTagValue(p, Tags.URL));
        assertEquals(TITLE, PageFactory.returnTagValue(p, Tags.TITLE));
        assertEquals(KEYWORDS, PageFactory.returnTagValue(p, Tags.KEYWORDS));
        assertNull(PageFactory.returnTagValue(p, Tags.DESCRIPTION));
        assertEquals(DESCRIPTION, PageFactory.returnTagValue(p, Tags.DC_DESCRIPTION));
    }

}