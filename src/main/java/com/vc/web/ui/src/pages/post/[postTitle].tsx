import { NextPageContext, NextPage } from "next"
import * as Constant from '../../const'
import { PostContent, getPostByTitle } from "../../model/PostContent"
import { generatePostUrl, urlVariableToValue } from '../../util/urlUtil'
import PageTitle from "../../component/layout/pageTitle"
import PostContentUI from "../../component/post/postContentUI"
import Metadata from "../../component/layout/metadata"

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
                    description={postContent.description}
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


interface PostPageContext extends NextPageContext {
    query: {
        postTitle: string
    }
}
PostPage.getInitialProps = async ({ query }: PostPageContext) => {
    const postTitleValue = urlVariableToValue(query.postTitle)
    return {
        postContent: await getPostByTitle(postTitleValue),
        metaUrl: generatePostUrl(postTitleValue, true)
    }
}
export default PostPage