package com.vc.web.model;

import java.util.Map;

public class Post {
    private String title;
    private String author;
    private String description;
    private FireStoreTimestamp createdAt;
    private int orderBy;
    private Map<String, String> tags;

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public FireStoreTimestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(FireStoreTimestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public Post(String title, String author, String description, Map<String, String> tags, FireStoreTimestamp createdAt, int orderBy) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.tags = tags;
        this.createdAt = createdAt;
        this.orderBy = orderBy;
    }
}

