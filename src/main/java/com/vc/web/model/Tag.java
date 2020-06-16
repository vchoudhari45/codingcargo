package com.vc.web.model;

public class Tag {
    private String title;
    private String type;
    private String description;
    private String keywords;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Tag(String title, String type, String description, String keywords) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.keywords = keywords;
    }

}
