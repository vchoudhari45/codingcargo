import { firestoreDb } from '../firebase/clientApp'
import { isUndefinedOrNull } from '../util/validator'
import { Category } from './Category'

export interface Tag {
    title: string,
    type: string,
    count: number,
    description: string,
    keywords: string
}

export interface TagListWithCategory {
    tagList: Tag[],
    category: Category
}
export const getAllTagByCategoryName = (categoryName: string, type: string): Promise<TagListWithCategory | undefined> => {
    try {
        if(isUndefinedOrNull(categoryName)) return Promise.resolve(undefined)
        
        const categoryPromise = firestoreDb.collection("category").doc(categoryName).get()
            .then(snapshot => {
                const category = JSON.parse(JSON.stringify(snapshot.data()))
                return category as Category
            })

        const tagListPromise = firestoreDb.collection("tag").where(categoryName, ">", 0).get()
            .then(snapshot => {
                const list: Tag[] = []
                snapshot.forEach(doc => {
                    const tag = JSON.parse(JSON.stringify(doc.data())) as Tag
                    if(tag.type == type) list.push(tag)
                })
                return list
            })

        const res = Promise.all([categoryPromise, tagListPromise])
            .then(promiseArr => {
                const category = promiseArr[0]
                const tagList = promiseArr[1]
                return <TagListWithCategory>{
                    tagList: tagList,
                    category: category
                }
            })
        return res
    } catch (err) {
        console.log(err)
        return Promise.resolve(undefined)
    }
}
