import { NextPage, GetStaticPaths, GetStaticProps, GetStaticPropsContext } from "next"
import { PostListWithTag, getPostListByCategoryAndTag } from "../../../../model/Post"
import PostListUI from "../../../../component/post/postListUI"
import * as Constant from '../../../../const'
import PageTitle from "../../../../component/layout/pageTitle"
import Metadata from "../../../../component/layout/metadata"
import { ParsedUrlQuery } from "querystring"
import { urlVariableToValue, generateTagUrl, _slug } from "../../../../util/urlUtil"
import { firestoreDb } from '../../../../firebase/clientApp'
import { Category } from "../../../../model/Category"

export interface TagProps {
    postListWithTag?: PostListWithTag
    categoryName: string
    tagName: string
    currentPage: number
    metaUrl: string
}
const TagValue: NextPage<TagProps> = ({ postListWithTag, categoryName, tagName, currentPage, metaUrl }: TagProps) => {
    if (typeof postListWithTag != 'undefined') {
        return (
            <>
                <PageTitle
                    title={tagName}
                    description={postListWithTag.tag.description} />

                <Metadata
                    title={tagName + " Problem Set - " + Constant.siteName}
                    description={postListWithTag.tag.description}
                    keywords={postListWithTag.tag.keywords}
                    url={metaUrl}
                    robots="index, nofollow" />

                <PostListUI
                    currentPage={currentPage}
                    postListWithTag={postListWithTag}
                    categoryName={categoryName}
                    tagName={tagName} />
            </>
        )
    }
    else return (<>{Constant.errorMessage}</>)
}

// interface TagContext extends NextPageContext {
//     query: {
//         category: string
//         tag: string
//     }
// }
// TagValue.getInitialProps = async ({ query }: TagContext) => {
//     const categoryValue = urlVariableToValue(query.category)
//     const tagValue = urlVariableToValue(query.tag)
//     return {
//         postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue),
//         categoryName: categoryValue,
//         tagName: tagValue,
//         currentPage: 0,
//         metaUrl: generateTagUrl(categoryValue, tagValue, true)
//     }
// }


interface TagValuePageUrlQuery extends ParsedUrlQuery {
    category?: string
    tag?: string
}
export const getStaticPaths: GetStaticPaths<TagValuePageUrlQuery> = async () => {
    const paths: { params: { category: string, tag: string } }[] = []
    const dbRef = firestoreDb

    const categoryQuery = await dbRef.collection("category").get()
    const categories: string[] = []
    categoryQuery.docs.forEach(async (categoryDoc) => {
        const category = JSON.parse(JSON.stringify(categoryDoc.data())) as Category
        categories.push(category.title)
    })

    const tagQuery = await dbRef.collection("tag").get()
    tagQuery.docs.forEach(tagDoc => {
        const tag = JSON.parse(JSON.stringify(tagDoc.data()))
        categories.forEach(category => {
            if (typeof tag[category] != 'undefined') {
                paths.push({ params: { category: _slug(category), tag: _slug(tag['title']) } })
            }
        })
    })

    return {
        paths: paths,
        fallback: false
    }
}
export const getStaticProps: GetStaticProps<TagProps> = async ({ params }: GetStaticPropsContext<TagValuePageUrlQuery>) => {
    const categoryValue = urlVariableToValue(params?.category as string)
    const tagValue = urlVariableToValue(params?.tag as string)
    return {
        props: {
            postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue),
            categoryName: categoryValue,
            tagName: tagValue,
            currentPage: 0,
            metaUrl: generateTagUrl(categoryValue, tagValue, true) + "/"
        }
    }
}

export default TagValue