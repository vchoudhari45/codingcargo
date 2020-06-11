package com.vc.web.connection;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.InputStream;

public class FireBaseApp {
    private static FirebaseApp firebaseApp = null;
    public static void initialize() {
        if(firebaseApp != null) return;
        try {
            InputStream serviceAccount = FireBaseApp.class.getClassLoader().getResourceAsStream("serviceAccount.json");
            assert serviceAccount != null;
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            firebaseApp = com.google.firebase.FirebaseApp.initializeApp(options);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
