package it.davideromito;

/**
 * Class to store all the constant information
 */
public interface Constant {
    String BASE_PAGE = "http://www.nhs.uk";
    String ROOT_PAGE = BASE_PAGE + "/Conditions/Pages/";
    String HOMEPAGE = ROOT_PAGE + "hub.aspx";

    String FILE_NAME = "FILE";

    Integer NUMBER_THREAD_POOL = 3;
    String HTML_A_HREF_TAG_PATTERN = "href=\"(.*?)\"";
}
