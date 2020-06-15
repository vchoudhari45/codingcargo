import { NextPageContext, NextPage } from "next"
import { getPostListByCategoryAndTag } from "../../../../model/Post"
import PostListUI from "../../../../component/post/postListUI"
import PageTitle from "../../../../component/layout/pageTitle"
import * as Constant from '../../../../const'
import Metadata from "../../../../component/layout/metadata"
import { generateTagUrl, urlVariableToValue } from "../../../../util/urlUtil"
import { TagProps } from "."

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

interface TagWithPaginationContext extends NextPageContext {
    query: {
        category: string
        tag: string
        page: string
    }
}
TagWithPagination.getInitialProps = async ({ query }: TagWithPaginationContext) => {
    const categoryValue = urlVariableToValue(query.category)
    const tagValue = urlVariableToValue(query.tag)
    const pageValue = urlVariableToValue(query.page)
    return {
        postListWithTag: await getPostListByCategoryAndTag(categoryValue, tagValue, pageValue),
        categoryName: categoryValue,
        tagName: tagValue,
        currentPage: Number.parseInt(pageValue),
        metaUrl: generateTagUrl(categoryValue, tagValue, true) + "/" + pageValue
    }
}
export default TagWithPagination