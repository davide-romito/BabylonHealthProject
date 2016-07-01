
package it.davideromito.crawler.parsing.jsoup;

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
        page.setDescription(doc.getElementsByAttributeValue(NAME,"description").attr(CONTENT));
        page.setKeywords(doc.getElementsByAttributeValue(NAME,"keywords").attr(CONTENT));
        page.getDc().setTitle(doc.getElementsByAttributeValue(NAME,"DC.title").attr(CONTENT));
        page.getDc().setDescription(doc.getElementsByAttributeValue(NAME,"DC.description").attr(CONTENT));
        page.getDc().setSubject(doc.getElementsByAttributeValue(NAME,"DC.subject").attr(CONTENT));
        page.getDc().setDateIssued(doc.getElementsByAttributeValue(NAME,"DC.date.issued").attr(CONTENT));
        page.getDc().setCoverage(doc.getElementsByAttributeValue(NAME,"DC.coverage").attr(CONTENT));
        page.getDc().setCreator(doc.getElementsByAttributeValue(NAME,"DC.creator").attr(CONTENT));
        page.getDc().setFormat(doc.getElementsByAttributeValue(NAME,"DC.format").attr(CONTENT));
        page.getDc().setLanguage(doc.getElementsByAttributeValue(NAME,"DC.language").attr(CONTENT));
        page.getDc().setIdentifier(doc.getElementsByAttributeValue(NAME,"DC.identifier").attr(CONTENT));
        page.getDc().setPublisher(doc.getElementsByAttributeValue(NAME,"DC.publisher").attr(CONTENT));
        page.getDc().setRights(doc.getElementsByAttributeValue(NAME,"DC.rights").attr(CONTENT));
        page.getEgms().setAccessibility(doc.getElementsByAttributeValue(NAME,"eGMS.accessibility").attr(CONTENT));
        page.getWt().setTi(doc.getElementsByAttributeValue(NAME,"WT.ti").attr(CONTENT));
        page.getDcSext().setRealUrl(doc.getElementsByAttributeValue(NAME,"DCSext.RealUrl").attr(CONTENT));
        page.getWt().setCgN(doc.getElementsByAttributeValue(NAME,"WT.cg_n").attr(CONTENT));
        page.getWt().setCgS(doc.getElementsByAttributeValue(NAME,"WT.cg_s").attr(CONTENT));
        page.getDcSext().setServer(doc.getElementsByAttributeValue(NAME,"DCSext.Server").attr(CONTENT));
        page.getWt().setSv(doc.getElementsByAttributeValue(NAME,"WT.sv").attr(CONTENT));
        page.getDcSext().setBmSection1(doc.getElementsByAttributeValue(NAME,"DCSext.BM_Section1").attr(CONTENT));
        page.getDcSext().setBmSection2(doc.getElementsByAttributeValue(NAME,"DCSext.BM_Section2").attr(CONTENT));
        page.getDcSext().setBmSection3(doc.getElementsByAttributeValue(NAME,"DCSext.BM_Section3").attr(CONTENT));
        return page;
    }
}
