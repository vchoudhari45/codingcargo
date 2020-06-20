import { NextPage, GetStaticPaths, GetStaticPropsContext, GetStaticProps } from "next"
import * as Constant from '../../const'
import { PostContent, getPostByTitle } from "../../model/PostContent"
import { generatePostUrl, urlVariableToValue, _slug } from '../../util/urlUtil'
import PageTitle from "../../component/layout/pageTitle"
import PostContentUI from "../../component/post/postContentUI"
import Metadata from "../../component/layout/metadata"
import { ParsedUrlQuery } from "querystring"
import { firestoreDb } from '../../firebase/clientApp'
import { Category } from "../../model/Category"
import { Post } from "../../model/Post"

interface Props {
    postContent?: PostContent
    metaUrl: string
}
const PostPage: NextPage<Props> = ({ postContent, metaUrl }) => {
    if (typeof postContent != 'undefined') {

        const tagArr: string[] = []
        for (const key in postContent.tags) tagArr.push(key)

        return (
            <>
                <Metadata
                    title={postContent.title + " - " + Constant.siteName}
                    description={postContent.metaDescription}
                    keywords={tagArr.join(", ")}
                    url={metaUrl}
                    robots="index, nofollow" />

                <PageTitle
                    title={postContent.title} />

                <PostContentUI
                    postContent={postContent} />
            </>
        )
    }
    else return (<div>{Constant.errorMessage}</div>)
}

// interface PostPageContext extends NextPageContext {
//     query: {
//         postTitle: string
//     }
// }
// PostPage.getInitialProps = async ({ query }: PostPageContext) => {
//     const postTitleValue = urlVariableToValue(query.postTitle)
//     return {
//         postContent: await getPostByTitle(postTitleValue),
//         metaUrl: generatePostUrl(postTitleValue, true)
//     }
// }

interface PostPageUrlQuery extends ParsedUrlQuery {
    postTitle?: string
}
export const getStaticPaths: GetStaticPaths<PostPageUrlQuery> = async () => {
    const paths : { params: { postTitle: string } }[] = []
    const dbRef = firestoreDb
    const categories = await dbRef.collection("category").get()

    const postQuery = await Promise.all(categories.docs.map(categoryDoc => {
        //for each category
        const category = JSON.parse(JSON.stringify(categoryDoc.data())) as Category    
        
        //get all posts
        return dbRef.collection("category").doc(category.title).collection("post").get()
    }))

    //append paths
    postQuery.forEach(postQuerySnapshot => {
        postQuerySnapshot.docs.map(postDoc => {
            const post = JSON.parse(JSON.stringify(postDoc.data())) as Post
            paths.push({ params: { postTitle: _slug(post.title) } })
        })
    })
    
    return {
        paths: paths,
        fallback: false
    }
}
export const getStaticProps: GetStaticProps<Props> = async ({ params }: GetStaticPropsContext<PostPageUrlQuery>) => {
    const postTitleValue = urlVariableToValue(params?.postTitle as string)
    console.log(postTitleValue)
    return {
        props: {
            postContent: await getPostByTitle(postTitleValue),
            metaUrl: generatePostUrl(postTitleValue, true) + "/"
        }
    }
}
export default PostPage