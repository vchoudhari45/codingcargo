import _Post from "./_post"
import Pagination from "../layout/pagination"
import { generateTagUrl } from "../../util/urlUtil"
import { PostListWithTag } from "../../model/Post"

interface Props {
    postListWithTag: PostListWithTag
    categoryName: string
    tagName: string
    currentPage: number
}
const PostListUI = ({ postListWithTag, categoryName, tagName, currentPage }: Props) => {
    const tagUrl = generateTagUrl(categoryName, tagName, false)
    const html = postListWithTag.list.map((post, i) => {
        return <_Post key={i} post={post} />
    })

    return (
        <>
            {html}
            <Pagination baseUrl={tagUrl}
                totalElements={postListWithTag.count}
                currentPage={currentPage} />
        </>
    )
}
export default PostListUI