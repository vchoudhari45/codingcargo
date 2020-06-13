import { firestoreDb } from '../firebase/clientApp'
import * as Constant from '../const'
import { Timestamp } from './Timestamp'
import { Tag } from './Tag'
import { isUndefinedOrNull, isInteger } from '../util/validator'

export interface Post {
    title: string
    author: string
    description: string
    createdAt: Timestamp
    orderBy: number
    tags: { [key: string]: string }
}
export interface PostListWithTag {
    list: Post[],
    count: number,
    tag: Tag
}
export const getPostListByCategoryAndTag = (
    category: string,
    tagValue: string,
    page?: string,
    pageSize?: string
): Promise<PostListWithTag | undefined> => {
    try {
        if(isUndefinedOrNull(category) || isUndefinedOrNull(tagValue)) return Promise.resolve(undefined)
        
        let pageSizeNumber = Constant.pageSize
        if(isUndefinedOrNull(pageSize)) pageSizeNumber = Constant.pageSize
        else if(!isInteger(pageSize)) return Promise.resolve(undefined)
        else pageSizeNumber = Number.parseInt(pageSize as string)

        let pageNumber = 0
        if(isUndefinedOrNull(page)) pageNumber = 0
        else if(!isInteger(page)) return Promise.resolve(undefined)
        else pageNumber =  Math.max(0, Number.parseInt(page as string) - 1)
    
        const dbRef = firestoreDb

        const tagPromise = dbRef.collection("tag").doc(tagValue).get()
            .then(doc => {
                const docData = doc.data()
                const tag = JSON.parse(JSON.stringify(docData)) as Tag
                return tag
            })

        const countPromise = dbRef.collection("tag").doc(tagValue).get()
            .then(doc => {
                const docData = doc.data()
                const count = JSON.parse(JSON.stringify(docData))[category] as number
                return count
            })

        const queryRef = dbRef
            .collection("category").doc(category)
            .collection("post")
            .where("tags." + tagValue, "==", true)
            .orderBy("createdAt", "desc")

        const listPromise = pageNumber != 0
            ? queryRef.limit(pageSizeNumber * pageNumber).get()
                .then(prevSnapshot => {
                    const last = prevSnapshot.docs[prevSnapshot.docs.length - 1]
                    const next = queryRef
                        .startAfter(last)
                        .limit(pageSizeNumber)
                        .get().then(nextSnapshot => {
                            const list: Post[] = []
                            nextSnapshot.forEach(doc => {
                                const nextDocData = doc.data()
                                const post = JSON.parse(JSON.stringify(nextDocData)) as Post
                                list.push(post)
                            })
                            return list
                        })
                    return next
                })
            : queryRef.limit(pageSizeNumber).get()
                .then(nextSnapshot => {
                    const list: Post[] = []
                    nextSnapshot.forEach(doc => {
                        const nextDocData = doc.data()
                        const post = JSON.parse(JSON.stringify(nextDocData)) as Post
                        list.push(post)
                    })
                    return list
                })

        const res = Promise.all([countPromise, listPromise, tagPromise])
            .then(promiseArr => {
                const count = promiseArr[0]
                const list: Post[] = promiseArr[1]
                const tag = promiseArr[2]
                return <PostListWithTag>{
                    count: count,
                    list: list,
                    tag: tag
                }
            })
        return res
    } catch (err) {
        console.log(err)
        return Promise.resolve(undefined)
    }
}