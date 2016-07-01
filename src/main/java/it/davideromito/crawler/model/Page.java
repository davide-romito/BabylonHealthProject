package it.davideromito.crawler.model;

/**
 * Created by dromito on 01/07/2016.
 */
public class Page {
    private String url;
    private String title;
    private String description;
    private String keywords;
    private DC dc;
    private EGMS egms;
    private WT wt;
    private DCSext dcSext;


    public Page(){
        this.dc = new DC();
        this.egms = new EGMS();
        this.wt = new WT();
        this.dcSext = new DCSext();
    }

    public Page(String url) {
        this();
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

    public DC getDc() {
        return dc;
    }

    public void setDc(DC dc) {
        this.dc = dc;
    }

    public EGMS getEgms() {
        return egms;
    }

    public void setEgms(EGMS egms) {
        this.egms = egms;
    }

    public WT getWt() {
        return wt;
    }

    public void setWt(WT wt) {
        this.wt = wt;
    }

    public DCSext getDcSext() {
        return dcSext;
    }

    public void setDcSext(DCSext dcSext) {
        this.dcSext = dcSext;
    }
}

