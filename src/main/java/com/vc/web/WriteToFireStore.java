package com.vc.web;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.vc.web.connection.FireBaseApp;
import com.vc.web.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class WriteToFireStore {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Config conf = ConfigFactory.load();

        String inputPaths = conf.getString("inputPaths");
        String errorPath = conf.getString("errorPath");
        String noPostPath = conf.getString("noPostPath");
        String noJavaPath = conf.getString("noJavaPath");
        String categoryPath = conf.getString("categoryPath");
        String tagPath = conf.getString("tagPath");
        String postPath = conf.getString("postPath");
        Scanner scan = new Scanner(System.in);

        try {
            //Take Backup of post.json
            backupOrRollback(postPath, false);

            //Read categories.json
            HashSet<String> categoryLookup = getCategoryLookup(categoryPath);

            //Read tags.json
            HashSet<String> tagLookup = getTagLookup(tagPath);

            //Read post.json
            HashSet<String> postLookup = getPostLookup(postPath);

            while (!writePostFile(gson, inputPaths, errorPath, postPath, noPostPath, noJavaPath, categoryLookup, tagLookup, postLookup)) {
                System.out.println();
                System.out.println("Nothing was written to FireStore, Fix below error:");

                //Print error to console
                Path error = Paths.get(errorPath);
                String errorContent = new String(Files.readAllBytes(error), StandardCharsets.UTF_8);
                System.out.println(errorContent);
                System.out.println("Press Y after fixing above issues...");
                while(!scan.nextLine().equals("Y"));

                //Repopulate category & tag lookup
                categoryLookup = getCategoryLookup(categoryPath);
                tagLookup = getTagLookup(tagPath);
            }

            System.out.println("Validate categories.json, post.json & tags.json using git dif and Press Y to continue writing to FireStore");
            while(!scan.nextLine().equals("Y"));

            System.out.println("Writing to FireStore");
            FireBaseApp.initialize();
            Firestore db = FirestoreClient.getFirestore();
            WriteBatch batch = db.batch();

            insertCategoryIntoFireStore(gson, categoryPath, db, batch);
            insertTagIntoFireStore(gson, tagPath, db, batch);
            insertPostIntoFireStore(gson, postPath, db, batch);

            ApiFuture<List<WriteResult>> writeResults = batch.commit();
            List<WriteResult> res = writeResults.get(); //blocking because it is commandline tool
            System.out.println("FireStore updated with "+res.size()+" records");

            System.out.println("Updating local files");
            updateSaved(categoryPath);
            updateSaved(postPath);
            updateSaved(tagPath);
            System.out.println("local files updated");
        }
        catch (Exception e) {
            try {
                System.out.println("Rolling back post.json file");
                backupOrRollback(postPath, true);
            }catch(IOException ex) {
                System.out.println("Failed rolling back "+postPath+" Please rollback manually");
            }
            e.printStackTrace();
        }
    }

    private static void backupOrRollback(String inputPath, boolean rollback) throws IOException {
        Path path = Paths.get(inputPath);
        Path bkpPath = Paths.get(path.toString().replaceAll("\\.json", "_bkp.json"));
        if(rollback) Files.copy(bkpPath, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        else Files.copy(path, bkpPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    private static void updateSaved(String inputPath) throws IOException {
        Path path = Paths.get(inputPath);
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        content = content.replaceAll("\"saved\": false", "\"saved\": true");
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }

    private static boolean writePostFile(
            Gson gson,
            String inputPathString,
            String errorPath,
            String postPath,
            String noPostPath,
            String noJavaPath,
            HashSet<String> categoryLookup,
            HashSet<String> tagLookup,
            HashSet<String> postLookup
    ) throws IOException {

        Path inputPaths = Paths.get(inputPathString);
        Stream<Path> stream = Files.walk(inputPaths, Integer.MAX_VALUE);

        //Write to validationError.txt
        AtomicBoolean hasValidationError = new AtomicBoolean(false);
        FileWriter validationErrorFile = new FileWriter(errorPath);

        //Write to post.json file
        FileWriter postFile = new FileWriter(postPath);
        FileWriter noPostFile = new FileWriter(noPostPath);
        FileWriter noJavaFile = new FileWriter(noJavaPath);

        postFile.write("[");
        postFile.write(System.lineSeparator());

        stream.forEach(path -> {
            try {
                if (Files.isRegularFile(path) & path.toString().endsWith(".java")) {
                    Post post = new Post();
                    PostContent postContent = new PostContent();

                    BufferedReader bufferedReader = Files.newBufferedReader(path);
                    String line = null;
                    boolean isComment = false;
                    String content = String.join("\n", Files.readAllLines(path));
                    content = content.replace("package com.vc.easy;", "");
                    content = content.replace("package com.vc.medium;", "");
                    content = content.replace("package com.vc.hard;", "");
                    content = content.replace("/*****", "");
                    content = content.replace("*****/", "");

                    while ((line = bufferedReader.readLine()) != null) {
                        if(line.contains("/*****")) isComment = true;
                        if(line.contains("*****/")) isComment = false;

                        if(!isComment) continue;

                        content = content.replace(line, "");
                        if (line.contains("Problem No:")) {
                            String problemNo = line.replaceAll("Problem No:", "").replaceAll("\\*", "").trim();
                            int orderBy = Integer.parseInt(problemNo);
                            post.setOrderBy(orderBy);
                            postContent.setOrderBy(orderBy);
                        }
                        if (line.contains("Category:")) {
                            String category = line.replaceAll("Category:", "").replaceAll("\\*", "").trim();
                            if(!categoryLookup.contains(category)) {
                                hasValidationError.set(true);
                                validationErrorFile.write(category+" from "+path+" not recognized ");
                                validationErrorFile.write(System.lineSeparator());
                            }
                            postContent.setCategory(category);
                        }
                        if (line.contains("Tags:")) {
                            String[] tags = line.replaceAll("Tags:", "").replaceAll("\\*", "").trim().split(", ");
                            Map<String, Boolean> tagsMap = new HashMap<String, Boolean>();
                            for(String tag: tags) {
                                if(!tagLookup.contains(tag)) {
                                    hasValidationError.set(true);
                                    validationErrorFile.write(tag+" from "+path+" not recognized");
                                    validationErrorFile.write(System.lineSeparator());
                                }
                                tagsMap.put(tag, true);
                            }
                            post.setTags(tagsMap);
                            postContent.setTags(tagsMap);
                        }
                        if (line.contains("Title:")) {
                            String title = line.replace("Title:", "").replaceAll("\\*", "").trim();
                            post.setTitle(title);
                            postContent.setTitle(title);
                        }
                        if (line.contains("Author:")) {
                            String author = line.replace("Author:", "").replaceAll("\\*", "").trim();
                            post.setAuthor(author);
                            postContent.setAuthor(author);
                        }
                        if (line.contains("Description:")) {
                            String description = line.replace("Description:", "").replaceAll("\\*", "").trim();
                            post.setDescription(description);
                            postContent.setDescription(description);
                        }
                        long timestamp = System.currentTimeMillis();
                        post.setCreatedAt(new FireStoreTimestamp(timestamp, 0));
                        postContent.setCreatedAt(new FireStoreTimestamp(timestamp, 0));
                    }
                    if(post.getTitle() != null && !post.getTitle().equals("")) {
                        content = content.replaceAll("\n\n\n\n\n","\n");
                        postContent.setContent(content);
                        if(post.getAuthor() == null || post.getAuthor().trim().equals("")) {
                            postContent.setAuthor("Vishal Choudhari");
                            post.setAuthor("Vishal Choudhari");
                        }
                        JsonObject postElement = gson.toJsonTree(post).getAsJsonObject();
                        postElement.addProperty("category", postContent.getCategory());
                        postElement.addProperty("content", postContent.getContent());
                        if(!postLookup.contains(post.getTitle())) {
                            postElement.addProperty("saved", false);
                        }
                        else {
                            postElement.addProperty("saved", true);
                        }
                        postFile.append(gson.toJson(postElement));
                    }
                    else {
                        noPostFile.append(path.toString());
                        noPostFile.append(System.lineSeparator());
                    }
                }
                else {
                    noJavaFile.append(path.toString());
                    noJavaFile.append(System.lineSeparator());
                }
            } catch(Exception e) {
                try {
                    validationErrorFile.append("Processing failed for ").append(path.getFileName().toString()).append(" with exception ").append(e.getMessage());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        postFile.append(System.lineSeparator());
        postFile.append("]");

        //Flush files
        postFile.flush();
        postFile.close();

        noPostFile.flush();
        noPostFile.close();

        noJavaFile.flush();
        noJavaFile.close();

        validationErrorFile.flush();
        validationErrorFile.close();

        return !hasValidationError.get();
    }

    private static HashSet<String> getCategoryLookup(String categoryPath) throws Exception {
        HashSet<String> str = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(categoryPath));
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();
        array.forEach(element -> {
            String category = element.getAsJsonObject().get("title").getAsString();
            str.add(category);
            if(!duplicate.add(category.toLowerCase())) list.add(category);
        });
        if(!list.isEmpty()) throw new Exception("Duplicate categories found "+list);
        return str;
    }

    private static HashSet<String> getTagLookup(String tagPath) throws Exception {
        HashSet<String> str = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(tagPath));
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();
        array.forEach(element -> {
            String tag = element.getAsJsonObject().get("title").getAsString();
            str.add(tag);
            if(!duplicate.add(tag.toLowerCase())) list.add(tag);
        });
        if(!list.isEmpty()) throw new Exception("Duplicate tag found "+list);
        return str;
    }

    private static HashSet<String> getPostLookup(String postPath) throws Exception {
        HashSet<String> str = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(postPath));
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();
        array.forEach(element -> {
            String tag = element.getAsJsonObject().get("title").getAsString();
            str.add(tag);
            if(!duplicate.add(tag.toLowerCase())) list.add(tag);
        });
        if(!list.isEmpty()) throw new Exception("Duplicate post found "+list);
        return str;
    }

    private static void insertCategoryIntoFireStore(Gson gson, String categoryPath, Firestore db, WriteBatch batch) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(categoryPath));
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();
        array.forEach(element -> {
            JsonObject categoryJsonObject = element.getAsJsonObject();
            if(!categoryJsonObject.get("saved").getAsBoolean()) {
                System.out.println("Saving..... Category "+categoryJsonObject.get("title").getAsString());
                DocumentReference categoryRef = db.collection("category").document(categoryJsonObject.get("title").getAsString());
                Category category = gson.fromJson(categoryJsonObject, Category.class);
                batch.set(categoryRef, category);
            }
        });
    }

    private static void insertTagIntoFireStore(Gson gson, String tagPath, Firestore db, WriteBatch batch) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(tagPath));
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();
        array.forEach(element -> {
            JsonObject tagJsonObject = element.getAsJsonObject();
            if(!tagJsonObject.get("saved").getAsBoolean()) {
                System.out.println("Saving..... Tag "+tagJsonObject.get("title").getAsString());
                DocumentReference tagRef = db.collection("tag").document(tagJsonObject.get("title").getAsString());
                Tag tag = gson.fromJson(tagJsonObject, Tag.class);
                batch.set(tagRef, tag);
            }
        });
    }

    private static void insertPostIntoFireStore(Gson gson, String postPath, Firestore db, WriteBatch batch) throws FileNotFoundException {
        FieldValue increment = FieldValue.increment(1);

        BufferedReader brPost = new BufferedReader(new FileReader(postPath));
        JsonParser postParser = new JsonParser();
        JsonArray postArr = postParser.parse(brPost).getAsJsonArray();

        postArr.forEach(element -> {
            JsonObject postJsonObject = element.getAsJsonObject();
            if(!postJsonObject.get("saved").getAsBoolean()) {
                System.out.println("Saving..... Post "+postJsonObject.get("title").getAsString());
                String title = postJsonObject.get("title").getAsString();
                String author = postJsonObject.get("author").getAsString();
                String description = postJsonObject.get("description").getAsString();
                String content = postJsonObject.get("content").getAsString();
                String category = postJsonObject.get("category").getAsString();
                Map<String, Boolean> tags = gson.fromJson(postJsonObject.get("tags").getAsJsonObject(), Map.class);
                FireStoreTimestamp createdAt = gson.fromJson(postJsonObject.get("createdAt").getAsJsonObject(), FireStoreTimestamp.class);
                int orderBy = postJsonObject.get("orderBy").getAsInt();

                //Create Post
                Post post = new Post();
                post.setTitle(title);
                post.setAuthor(author);
                post.setDescription(description);
                post.setCreatedAt(createdAt);
                post.setOrderBy(orderBy);
                post.setTags(tags);
                DocumentReference postRef = db.collection("category").document(category).collection("post").document(title);
                batch.set(postRef, post);

                //Create Post Content
                PostContent postContent = new PostContent();
                postContent.setTitle(title);
                postContent.setAuthor(author);
                postContent.setCategory(category);
                postContent.setDescription(description);
                postContent.setContent(content);
                postContent.setCreatedAt(createdAt);
                postContent.setOrderBy(orderBy);
                postContent.setTags(tags);
                DocumentReference postContentRef = db.collection("postContent").document(title);
                batch.set(postContentRef, postContent);

                //Update Category Count
                DocumentReference categoryCountRef = db.collection("category").document(category);
                batch.update(categoryCountRef, "count", increment);

                //Update Category Count Under Tag
                tags.forEach((key, value) -> {
                    DocumentReference tagCountRef = db.collection("tag").document(key);
                    batch.update(tagCountRef, category, increment);
                });
            }
        });
    }
}
