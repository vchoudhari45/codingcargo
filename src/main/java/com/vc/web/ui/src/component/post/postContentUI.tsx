import Link from 'next/link'
import { PostContent } from '../../model/PostContent'
import { generateTagUrl } from '../../util/urlUtil'

interface Props {
    postContent: PostContent
}
const PostContentUI = ({postContent}: Props) => {
    const tagHtml: JSX.Element[] = []

    for (const tag in postContent.tags) {
       tagHtml.push(
            <Link key={tag} href={generateTagUrl(postContent.category, tag, false)}>
                <a className="capitalize mr-2 nounderline hover:underline ">{tag}</a>
            </Link>
       )
    }
    
    return (
        <>
           <div className="flex justify-start items-baseline text-sm text-gray-700 mb-6">
                <div className="text-gray-900 font-bold mr-2">Tags</div>
                {tagHtml}
            </div>
            <div>{postContent.content}</div>
        </>
    )
}

export default PostContentUI