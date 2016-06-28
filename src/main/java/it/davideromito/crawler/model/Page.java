package it.davideromito.crawler.model;

/**
 * Created by davideromito on 28/06/16.
 */
public class Page {
    private String url;
    private String title;
    private String description;
    private String keywords;
    private String dcTitle;
    private String dcDescription;
    //TODO extend

    public Page(){}

    public Page(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDcTitle() {
        return dcTitle;
    }

    public void setDcTitle(String dcTitle) {
        this.dcTitle = dcTitle;
    }

    public String getDcDescription() {
        return dcDescription;
    }

    public void setDcDescription(String dcDescription) {
        this.dcDescription = dcDescription;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                ", dcTitle='" + dcTitle + '\'' +
                ", dcDescription='" + dcDescription + '\'' +
                '}';
    }

}
