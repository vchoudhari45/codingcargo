package com.vc.web.model;

import java.util.Map;

public class PostContent {
    private String title;
    private String author;
    private String category;
    private String description;
    private String content;
    private FireStoreTimestamp createAt;
    private int orderBy;
    private Map<String, Object> tags;
}
