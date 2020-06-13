import firebase from 'firebase/app'
import 'firebase/analytics'
import 'firebase/auth'
import 'firebase/firestore'

export interface FirebaseClientConfig {
  apiKey: String | undefined,
  authDomain: String | undefined,
  databaseURL: String | undefined,
  projectId: String | undefined,
  storageBucket: String | undefined,
  messagingSenderId: String | undefined,
  appId: String | undefined,
  measurementId: String | undefined
}

const firebaseClientConfig: FirebaseClientConfig = {
  apiKey: process.env.FIREBASE_API_KEY,
  authDomain: process.env.FIREBASE_AUTH_DOMAIN,
  databaseURL: process.env.FIREBASE_DATABASE_URL,
  projectId: process.env.FIREBASE_PROJECT_ID,
  storageBucket: process.env.FIREBASE_STORAGE_BUCKET,
  messagingSenderId: process.env.FIREBASE_MESSAGING_SENDER_ID,
  appId: process.env.FIREBASE_APP_ID,
  measurementId: process.env.FIREBASE_MEASUREMENT_ID
}

try {
  // Check that `window` is in scope for the analytics module'
  if (!firebase.apps.length) {
    firebase.initializeApp(firebaseClientConfig)
    // To enable analytics. https://firebase.google.com/docs/analytics/get-started
    if (typeof window !== 'undefined' && 'measurementId' in firebaseClientConfig) {
      const firebaseAnalytics = firebase.analytics()
    }
  }
} catch (err) {
  console.log(err)
}

export const firebaseApp = firebase
export const firestoreDb = firebase.firestore()
export const firebaseAuth = firebase.auth()