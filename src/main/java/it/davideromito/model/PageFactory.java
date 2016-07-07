package it.davideromito.model;

import it.davideromito.Tags;

/**
 * Class to extract the value of a tag in the Page model
 */
public class PageFactory {
    public static String returnTagValue(Page p, Tags tag) {
        String strToReturn = "";
        switch (tag) {
            case URL:
                strToReturn = p.getUrl();
                break;
            case TITLE:
                strToReturn = p.getTitle();
                break;
            case DESCRIPTION:
                strToReturn = p.getDescription();
                break;
            case KEYWORDS:
                strToReturn = p.getKeywords();
                break;
            case DC_TITLE:
                strToReturn = p.getDc().getTitle();
                break;
            case DC_DESCRIPTION:
                strToReturn = p.getDc().getDescription();
                break;
            case DC_SUBJECT:
                strToReturn = p.getDc().getSubject();
                break;
            case DC_DATE_ISSUED:
                strToReturn = p.getDc().getDateIssued();
                break;
            case DC_COVERAGE:
                strToReturn = p.getDc().getCoverage();
                break;
            case DC_CREATOR:
                strToReturn = p.getDc().getCreator();
                break;
            case DC_FORMAT:
                strToReturn = p.getDc().getFormat();
                break;
            case DC_LANGUAGE:
                strToReturn = p.getDc().getLanguage();
                break;
            case DC_IDENTIFIER:
                strToReturn = p.getDc().getIdentifier();
                break;
            case DC_PUBLISHER:
                strToReturn = p.getDc().getPublisher();
                break;
            case DC_RIGHTS:
                strToReturn = p.getDc().getRights();
                break;
            case EGMS_ACCESSIBILITY:
                strToReturn = p.getEgms().getAccessibility();
                break;
            case WT_TI:
                strToReturn = p.getWt().getTi();
                break;
            case DCSEXT_REALURL:
                strToReturn = p.getDcSext().getRealUrl();
                break;
            case WT_CGN:
                strToReturn = p.getWt().getCgN();
                break;
            case WT_CGS:
                strToReturn = p.getWt().getCgS();
                break;
            case DCSEXT_SERVER:
                strToReturn = p.getDcSext().getServer();
                break;
            case WT_SV:
                strToReturn = p.getWt().getSv();
                break;
            case DCSEXT_BM_SECTION1:
                strToReturn = p.getDcSext().getBmSection1();
                break;
            case DCSEXT_BM_SECTION2:
                strToReturn = p.getDcSext().getBmSection2();
                break;
            case DCSEXT_BM_SECTION3:
                strToReturn = p.getDcSext().getBmSection3();
                break;
        }
        return strToReturn != null ? strToReturn : "";
    }

}
