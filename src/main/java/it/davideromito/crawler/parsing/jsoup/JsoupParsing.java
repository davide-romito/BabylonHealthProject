
package it.davideromito.crawler.parsing.jsoup;

import it.davideromito.Tags;
import it.davideromito.crawler.model.Page;
import it.davideromito.crawler.parsing.Parsing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by davideromito on 28/06/16.
 */
public class JsoupParsing implements Parsing {
    private static final String NAME = "name";
    private static final String CONTENT = "content";

    public Page retrievePage(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Page page = new Page(url);
        page.setTitle(doc.title());
        page.setDescription(doc.getElementsByAttributeValue(NAME, Tags.DESCRIPTION.name()).attr(CONTENT));
        page.setKeywords(doc.getElementsByAttributeValue(NAME, Tags.KEYWORDS.name()).attr(CONTENT));
        page.getDc().setTitle(doc.getElementsByAttributeValue(NAME, Tags.DC_TITLE.name()).attr(CONTENT));
        page.getDc().setDescription(doc.getElementsByAttributeValue(NAME, Tags.DC_DESCRIPTION.name()).attr(CONTENT));
        page.getDc().setSubject(doc.getElementsByAttributeValue(NAME, Tags.DC_SUBJECT.name()).attr(CONTENT));
        page.getDc().setDateIssued(doc.getElementsByAttributeValue(NAME, Tags.DC_DATE_ISSUED.name()).attr(CONTENT));
        page.getDc().setCoverage(doc.getElementsByAttributeValue(NAME, Tags.DC_COVERAGE.name()).attr(CONTENT));
        page.getDc().setCreator(doc.getElementsByAttributeValue(NAME, Tags.DC_CREATOR.name()).attr(CONTENT));
        page.getDc().setFormat(doc.getElementsByAttributeValue(NAME, Tags.DC_FORMAT.name()).attr(CONTENT));
        page.getDc().setLanguage(doc.getElementsByAttributeValue(NAME, Tags.DC_LANGUAGE.name()).attr(CONTENT));
        page.getDc().setIdentifier(doc.getElementsByAttributeValue(NAME, Tags.DC_IDENTIFIER.name()).attr(CONTENT));
        page.getDc().setPublisher(doc.getElementsByAttributeValue(NAME, Tags.DC_PUBLISHER.name()).attr(CONTENT));
        page.getDc().setRights(doc.getElementsByAttributeValue(NAME, Tags.DC_RIGHTS.name()).attr(CONTENT));
        page.getEgms().setAccessibility(doc.getElementsByAttributeValue(NAME, Tags.EGMS_ACCESSIBILITY.name()).attr(CONTENT));
        page.getWt().setTi(doc.getElementsByAttributeValue(NAME, Tags.WT_TI.name()).attr(CONTENT));
        page.getDcSext().setRealUrl(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_REALURL.name()).attr(CONTENT));
        page.getWt().setCgN(doc.getElementsByAttributeValue(NAME, Tags.WT_CGN.name()).attr(CONTENT));
        page.getWt().setCgS(doc.getElementsByAttributeValue(NAME, Tags.WT_CGS.name()).attr(CONTENT));
        page.getDcSext().setServer(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_SERVER.name()).attr(CONTENT));
        page.getWt().setSv(doc.getElementsByAttributeValue(NAME, Tags.WT_SV.name()).attr(CONTENT));
        page.getDcSext().setBmSection1(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION1.name()).attr(CONTENT));
        page.getDcSext().setBmSection2(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION2.name()).attr(CONTENT));
        page.getDcSext().setBmSection3(doc.getElementsByAttributeValue(NAME, Tags.DCSEXT_BM_SECTION3.name()).attr(CONTENT));
        return page;
    }
}
