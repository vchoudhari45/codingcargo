package com.vc.web.model;

import java.util.List;
import java.util.Map;

public class PostContent {
    private String title;
    private String author;
    private String category;
    private String description;
    private String content;
    private FireStoreTimestamp createdAt;
    private int orderBy;
    private Map<String, String> tags;
    private List<String> suggestions;

    public PostContent() {

    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public PostContent(String title, String author, String category, String description, String content, FireStoreTimestamp createdAt, int orderBy, Map<String, String> tags, List<String> suggestions) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
        this.orderBy = orderBy;
        this.tags = tags;
        this.suggestions = suggestions;
    }
}
