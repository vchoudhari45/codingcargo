package com.vc.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vc.web.model.FireStoreTimestamp;
import com.vc.web.model.Post;

public class FireStoreDbInsert {
    public static void main(String[] args) {
        Post p = new Post(
                "Title",
                "Author",
                "Description",
                "Content",
                "Category",
                new String[]{"Arr1"},
                new FireStoreTimestamp(1,2),
                1,
                false
        );
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(p);
        System.out.println(jsonString);
    }
}
