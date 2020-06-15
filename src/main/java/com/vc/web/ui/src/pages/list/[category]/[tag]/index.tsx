import { NextPageContext, NextPage } from "next"
import { PostListWithTag, getPostListByCategoryAndTag } from "../../../../model/Post"
import PostListUI from "../../../../component/post/postListUI"
import * as Constant from '../../../../const'
import PageTitle from "../../../../component/layout/pageTitle"
import Metadata from "../../../../component/layout/metadata"
import { generateTagUrl, urlVariableToValue } from "../../../../util/urlUtil"

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

interface TagContext extends NextPageContext {
    query: {
        category: string
        tag: string
    }
}
TagValue.getInitialProps = async ({ query }: TagContext) => {
    const categoryValue = urlVariableToValue(query.category)
    const tagValue = urlVariableToValue(query.tag)
    return {
        postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue),
        categoryName: categoryValue,
        tagName: tagValue,
        currentPage: 0,
        metaUrl: generateTagUrl(categoryValue, tagValue, true)
    }
}
export default TagValue