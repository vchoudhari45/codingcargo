import { firestoreDb } from '../firebase/clientApp'
import { Timestamp } from './Timestamp'
import { isUndefinedOrNull } from '../util/validator'

export interface PostContent {
    title: string
    author: string
    category: string
    description: string
    content: string
    createdAt: Timestamp
    orderBy: number
    tags: { [key: string]: string }
}
export const getPostByTitle = (postTitle: string): Promise<PostContent | undefined> => {
    try {

        if(isUndefinedOrNull(postTitle)) return Promise.resolve(undefined)

        const dbRef = firestoreDb
        const post = dbRef
            .collection("postContent")
            .where("title", "==", postTitle).get()
            .then(
                snapshot => {
                    if (snapshot.docs.length > 0) {
                        const doc = snapshot.docs[0]
                        const post = JSON.parse(JSON.stringify(doc.data()))
                        return (post as PostContent)
                    }
                    else return Promise.resolve(undefined)
                }
            )
        return post
    } catch (err) {
        console.log(err)
        return Promise.resolve(undefined)
    }
}