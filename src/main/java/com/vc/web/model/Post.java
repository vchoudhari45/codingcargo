package com.vc.web.model;

public class Post {
    private String title;
    private String author;
    private String description;
    private String content;
    private String category;
    private String[] tags;
    private FireStoreTimestamp createdAt;
    private int orderBy;
    private boolean saved;

    public Post(String title, String author, String description, String content, String category, String[] tags, FireStoreTimestamp createdAt, int orderBy, boolean saved) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.content = content;
        this.category = category;
        this.tags = tags;
        this.createdAt = createdAt;
        this.orderBy = orderBy;
        this.saved = saved;
    }
}

