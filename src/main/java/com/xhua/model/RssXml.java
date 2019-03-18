package com.xhua.model;

public class RssXml {
    private Integer id;

    private Integer sourceId;

    private Integer typeId;

    private String rssUrl;

    private String rssDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getRssUrl() {
        return rssUrl;
    }

    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl == null ? null : rssUrl.trim();
    }

    public String getRssDescribe() {
        return rssDescribe;
    }

    public void setRssDescribe(String rssDescribe) {
        this.rssDescribe = rssDescribe == null ? null : rssDescribe.trim();
    }
}