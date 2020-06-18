import { NextPage, GetStaticPaths, GetStaticProps, GetStaticPropsContext } from "next"
import { getPostListByCategoryAndTag } from "../../../../model/Post"
import PostListUI from "../../../../component/post/postListUI"
import PageTitle from "../../../../component/layout/pageTitle"
import * as Constant from '../../../../const'
import Metadata from "../../../../component/layout/metadata"
import { generateTagUrl, urlVariableToValue, _slug } from "../../../../util/urlUtil"
import { TagProps } from "."
import { ParsedUrlQuery } from "querystring"
import { firestoreDb } from '../../../../firebase/clientApp'
import { Category } from "../../../../model/Category"

const TagWithPagination: NextPage<TagProps> = ({ postListWithTag, categoryName, tagName, currentPage, metaUrl }: TagProps) => {
    if (typeof postListWithTag != 'undefined') {
        return (
            <>
                <PageTitle
                    title={tagName}
                    description={postListWithTag.tag.description} />

                {currentPage == 1
                    ? <Metadata
                            title={tagName + " Problem Set - " + Constant.siteName}
                            description={postListWithTag.tag.description}
                            keywords={postListWithTag.tag.keywords}
                            url={metaUrl}
                            robots="index, nofollow"
                            canonical={metaUrl.replace("/1", "")} />
                    : <Metadata
                            title={tagName + " Problem Set - " + Constant.siteName}
                            description={postListWithTag.tag.description}
                            keywords={postListWithTag.tag.keywords}
                            url={metaUrl}
                            robots="index, nofollow" />

                }

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

// interface TagWithPaginationContext extends NextPageContext {
//     query: {
//         category: string
//         tag: string
//         page: string
//     }
// }
// TagWithPagination.getInitialProps = async ({ query }: TagWithPaginationContext) => {
//     const categoryValue = urlVariableToValue(query.category)
//     const tagValue = urlVariableToValue(query.tag)
//     const pageValue = urlVariableToValue(query.page)
//     return {
//         postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue, pageValue),
//         categoryName: categoryValue,
//         tagName: tagValue,
//         currentPage: Number.parseInt(pageValue),
//         metaUrl: generateTagUrl(categoryValue, tagValue, true) + "/" + pageValue
//     }
// }

interface TagValuePageUrlQuery extends ParsedUrlQuery {
    category?: string
    tag?: string
    page?: string
}
export const getStaticPaths: GetStaticPaths<TagValuePageUrlQuery> = async () => {
    const paths: { params: { category: string, tag: string, page: string } }[] = []
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
                //pagination
                const postCount =  Number.parseInt(tag[category])
                let pageCount = postCount / Constant.pageSize
                pageCount += (postCount % Constant.pageSize) != 0 ? 1 : 0;
                for(let i = 1; i <= pageCount; i++) {
                    paths.push({ params: { category: _slug(category), tag: _slug(tag['title']), page: i.toString() }})
                }
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
    const pageValue = urlVariableToValue(params?.page as string)
    return {
        props: {
            postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue, pageValue),
            categoryName: categoryValue,
            tagName: tagValue,
            currentPage: Number.parseInt(pageValue),
            metaUrl: generateTagUrl(categoryValue, tagValue, true) + "/" + pageValue + "/"
        }
    }
}
export default TagWithPagination