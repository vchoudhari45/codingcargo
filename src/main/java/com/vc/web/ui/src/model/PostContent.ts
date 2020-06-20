import { firestoreDb } from '../firebase/clientApp'
import { Timestamp } from './Timestamp'
import { isUndefinedOrNull } from '../util/validator'

export interface PostContent {
    title: string
    author: string
    category: string
    metaDescription: string
    description: string
    content: string
    createdAt: Timestamp
    orderBy: number
    tags: { [key: string]: string },
    suggestions: string[]
}
export const getPostByTitle = (postTitle: string): Promise<PostContent | undefined> => {
    try {

        if(isUndefinedOrNull(postTitle)) return Promise.resolve(undefined)

        const dbRef = firestoreDb
        const post = dbRef
            .collection("postContent")
            .doc(postTitle).get()
            .then(
                async(doc) => {
                    if(doc.exists) {
                        const post = JSON.parse(JSON.stringify(doc.data())) as PostContent
                        
                        for(const tag in post.tags) {
                            if(post.tags[tag] != 'Data Structures And Algorithms') {
                                delete post.tags[tag]
                            }
                        }

                        //Check if Suggestions Post Exists in FireStore, This is heavy feature remove if it doesn't work
                        const suggestionsExists: string[] = []
                        await Promise.all(post.suggestions.map(async(suggestionTitle) => {
                            const suggestionPostRef = dbRef.collection("postContent").doc(suggestionTitle)
                            const suggestionDoc = await suggestionPostRef.get()
                            if(suggestionDoc.exists) {
                                const suggestionPostContent = suggestionDoc.data() as PostContent;
                                suggestionsExists.push(suggestionPostContent.title)
                            }
                        }))

                        post.suggestions = suggestionsExists
                        //This is heavy feature remove if it doesn't work
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