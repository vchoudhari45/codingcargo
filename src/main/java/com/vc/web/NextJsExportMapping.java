package com.vc.web;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.vc.web.connection.FireBaseApp;
import com.vc.web.util.UrlUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.vc.web.model.ExportMapConstants.*;

public class NextJsExportMapping {
    private static Map<String, String> exportMap = new LinkedHashMap<>();
    private static Config conf = ConfigFactory.load();

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        System.out.println("Connecting to FireBase");
        FireBaseApp.initialize();
        Firestore db = FirestoreClient.getFirestore();

        System.out.println("Exporting index & error pages");
        //Home Pages
        exportMap.put(HOME_PAGE, EXPORT_MAP_FORMAT.replaceAll("#PATH#", HOME_PAGE));
        exportMap.put(INDEX_PAGE, EXPORT_MAP_FORMAT.replaceAll("#PATH#", INDEX_PAGE));

        //Error Pages
        exportMap.put(ERROR_404, EXPORT_MAP_FORMAT.replaceAll("#PATH#", ERROR_404));
        System.out.println("Done exporting index & error pages");

        //Category Pages
        HashSet<String> categories = new HashSet<>();
        CollectionReference categoriesColRef = db.collection("category");
        Iterable<DocumentReference> categoriesDocRefItr = categoriesColRef.listDocuments();
        System.out.println("Iterating over category doc");
        categoriesDocRefItr.forEach(categoryDocRef -> {
            ApiFuture<DocumentSnapshot> future = categoryDocRef.get();
            try {
                DocumentSnapshot categoryDocument = future.get();
                Map<String, Object> map = categoryDocument.getData();
                assert map != null;

                String category = map.get("title").toString();
                categories.add(category);

                System.out.println("exporting category page for "+category);
                String categoryUrl = UrlUtil.slug(category);
                exportMap.put(CATEGORY_PAGE.replace(CATEGORY, categoryUrl), EXPORT_MAP_FORMAT.replaceAll("#PATH#", CATEGORY_PAGE));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        });

        //Tag Pages
        CollectionReference tagColRef = db.collection("tag");
        Iterable<DocumentReference> tagDocRefItr = tagColRef.listDocuments();
        tagDocRefItr.forEach(tagDocRef -> {
            ApiFuture<DocumentSnapshot> future = tagDocRef.get();
            try {
                DocumentSnapshot tagDocument = future.get();
                Map<String, Object> map = tagDocument.getData();
                assert map != null;

                System.out.println("exporting tag page for "+map.get("title").toString());
                for(String category: categories) {
                    if(map.containsKey(category)) {
                        String tag = map.get("title").toString();
                        String tagUrl = UrlUtil.slug(tag);
                        String categoryUrl = UrlUtil.slug(category);
                        exportMap.put(TAG_PAGE.replace(CATEGORY, categoryUrl).replace(TAG, tagUrl), EXPORT_MAP_FORMAT.replaceAll("#PATH#", TAG_PAGE));

                        //Pagination
                        int postCount = Integer.parseInt(map.get(category).toString());
                        int pagesCount = postCount / PAGE_SIZE;
                        pagesCount += postCount % PAGE_SIZE != 0 ? 1 : 0;
                        for(int i = 1; i <= pagesCount; i++) {
                            exportMap.put(TAG_PAGE_WITH_PAGINATION.replace(CATEGORY, categoryUrl).replace(TAG, tagUrl).replace(PAGE, String.valueOf(i)), EXPORT_MAP_FORMAT.replaceAll("#PATH#", TAG_PAGE_WITH_PAGINATION));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        });

        //Post Title
        for(String category: categories) {
            CollectionReference postColRef = db.collection("category").document(category).collection("post");
            Iterable<DocumentReference> postDocRefItr = postColRef.listDocuments();
            postDocRefItr.forEach(postDocRef -> {
                ApiFuture<DocumentSnapshot> future = postDocRef.get();
                try {
                    DocumentSnapshot tagDocument = future.get();
                    Map<String, Object> map = tagDocument.getData();
                    assert map != null;

                    String postTitle = map.get("title").toString();
                    String postTitleUrl = UrlUtil.slug(postTitle);

                    System.out.println("exporting post page for "+postTitle);

                    exportMap.put(POST_TITLE_PAGE.replace(POST_TITLE, postTitleUrl), EXPORT_MAP_FORMAT.replaceAll("#PATH#", POST_TITLE_PAGE));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            });
        }

        StringBuilder str = new StringBuilder();
        str.append("{\n");
        exportMap.forEach((key, value) -> {
            str.append("\t\t")
               .append("\"")
               .append(key)
               .append("\"")
               .append(" : ")
               .append(value)
               .append(",")
               .append("\n");
        });
        str.append("\t");
        str.append("}");

        String nextJsConfigSrc = conf.getString("nextJSConfigSrc");
        Path nextJSConfigSrcPath = Paths.get(nextJsConfigSrc);

        String nextJsConfigDest = conf.getString("nextJSConfigDest");
        Path nextJSConfigDestPath = Paths.get(nextJsConfigDest);

        String nextJsConfigSrcContent = new String(Files.readAllBytes(nextJSConfigSrcPath), StandardCharsets.UTF_8);
        nextJsConfigSrcContent = nextJsConfigSrcContent.replaceAll("##NEXT_JS_EXPORT_MAPPING_PLACEHOLDER##", str.toString());

        Files.write(nextJSConfigDestPath, nextJsConfigSrcContent.getBytes(StandardCharsets.UTF_8));
    }
}
