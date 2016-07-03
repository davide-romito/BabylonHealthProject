package it.davideromito;

/**
 * Tags to retrieve from the HTML pages
 */
public enum Tags {
    DESCRIPTION("description"),
    KEYWORDS("keywords"),
    DC_TITLE("DC.title"),
    DC_DESCRIPTION("DC.description"),
    DC_SUBJECT("DC.subject"),
    DC_DATE_ISSUED("DC.date.issued"),
    DC_COVERAGE("DC.coverage"),
    DC_CREATOR("DC.creator"),
    DC_FORMAT("DC.format"),
    DC_LANGUAGE("DC.language"),
    DC_IDENTIFIER("DC.identifier"),
    DC_PUBLISHER("DC.publisher"),
    DC_RIGHTS("DC.rights"),
    EGMS_ACCESSIBILITY("eGMS.accessibility"),
    WT_TI("WT.ti"),
    DCSEXT_REALURL("DCSext.RealUrl"),
    WT_CGN("WT.cg_n"),
    WT_CGS("WT.cg_s"),
    DCSEXT_SERVER("DCSext.Server"),
    WT_SV("WT.sv"),
    DCSEXT_BM_SECTION1("DCSext.BM_Section1"),
    DCSEXT_BM_SECTION2("DCSext.BM_Section2"),
    DCSEXT_BM_SECTION3("DCSext.BM_Section3");

    Tags(String label) {
    }
}
