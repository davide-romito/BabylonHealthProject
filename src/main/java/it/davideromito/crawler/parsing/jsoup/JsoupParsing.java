
package it.davideromito.crawler.parsing.jsoup;

import it.davideromito.Tags;
import it.davideromito.model.Page;
import it.davideromito.crawler.parsing.Parsing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParsing implements Parsing {
    private static final String NAME = "name";
    private static final String CONTENT = "content";

    /**
     * given an URl, retrieve the element of the page and create and object Page
     * @param url
     * @return the object Page with all the elemnt retrieved from the url
     * @throws IOException
     */
    public Page retrievePage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Page page = new Page(url);
        page.setTitle(doc.title());
        page.setDescription(doc.getElementsByAttributeValue(NAME, Tags.DESCRIPTION.label()).attr(CONTENT));
        page.setKeywords(doc.getElementsByAttributeValue(NAME, Tags.KEYWORDS.label()).attr(CONTENT));
        page.getDc().setTitle(doc.getElementsByAttributeValue(NAME, Tags.DC_TITLE.label()).attr(CONTENT));
        page.getDc().setDescription(doc.getElementsByAttributeValue(NAME, Tags.DC_DESCRIPTION.label()).attr(CONTENT));
        page.getDc().setSubject(doc.getElementsByAttributeValue(NAME, Tags.DC_SUBJECT.label()).attr(CONTENT));
        page.getDc().setDateIssued(doc.getElementsByAttributeValue(NAME, Tags.DC_DATE_ISSUED.label()).attr(CONTENT));
        page.getDc().setCoverage(doc.getElementsByAttributeValue(NAME, Tags.DC_COVERAGE.label()).attr(CONTENT));
        page.getDc().setCreator(doc.getElementsByAttributeValue(NAME, Tags.DC_CREATOR.label()).attr(CONTENT));
        page.getDc().setFormat(doc.getElementsByAttributeValue(NAME, Tags.DC_FORMAT.label()).attr(CONTENT));
        page.getDc().setLanguage(doc.getElementsByAttributeValue(NAME, Tags.DC_LANGUAGE.label()).attr(CONTENT));
        page.getDc().setIdentifier(doc.getElementsByAttributeValue(NAME, Tags.DC_IDENTIFIER.label()).attr(CONTENT));
        page.getDc().setPublisher(doc.getElementsByAttributeValue(NAME, Tags.DC_PUBLISHER.label()).attr(CONTENT));
        page.getDc().setRights(doc.getElementsByAttributeValue(NAME, Tags.DC_RIGHTS.label()).attr(CONTENT));
        page.getEgms().setAccessibility(doc.getElementsByAttributeValue(NAME, Tags.EGMS_ACCESSIBILITY.label()).attr(CONTENT));
        page.getWt().setTi(doc.getElementsByAttributeValue(NAME, Tags.WT_TI.label()).attr(CONTENT));
        page.getDcSext().setRealUrl(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_REALURL.label()).attr(CONTENT));
        page.getWt().setCgN(doc.getElementsByAttributeValue(NAME, Tags.WT_CGN.label()).attr(CONTENT));
        page.getWt().setCgS(doc.getElementsByAttributeValue(NAME, Tags.WT_CGS.label()).attr(CONTENT));
        page.getDcSext().setServer(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_SERVER.label()).attr(CONTENT));
        page.getWt().setSv(doc.getElementsByAttributeValue(NAME, Tags.WT_SV.label()).attr(CONTENT));
        page.getDcSext().setBmSection1(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION1.label()).attr(CONTENT));
        page.getDcSext().setBmSection2(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION2.label()).attr(CONTENT));
        page.getDcSext().setBmSection3(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION3.label()).attr(CONTENT));
        return page;
    }
}
