import Link from 'next/link'
import { PostContent } from '../../model/PostContent'
import { generateTagUrl, generatePostUrl } from '../../util/urlUtil'
import Prism from 'prismjs'
import "prismjs/components/prism-java"
import React, { useEffect } from 'react'

interface Props {
    postContent: PostContent
}
const PostContentUI = ({postContent}: Props) => {
    const tagHtml: JSX.Element[] = []
    
    useEffect(() => {
        Prism.highlightAll()
    });

    const tags = Object.keys(postContent.tags).sort()
    for (const tagIndex in tags) {
       tagHtml.push(
            <div key={tags[tagIndex]} className="px-2 py-2">
                <Link href={generateTagUrl(postContent.category, tags[tagIndex], false)}>
                    <a className="capitalize hover:underline nounderline text-sm md:text-base text-gray-700">{tags[tagIndex]}</a>
                </Link>
            </div>
       )
    }

    const suggestionsHtml: JSX.Element[] = []
    for (const suggestion in postContent.suggestions) {
        suggestionsHtml.push(
             <div key={postContent.suggestions[suggestion]} className="capitalize hover:underline nounderline text-sm md:text-base leading-relaxed">
                 <Link href={generatePostUrl(postContent.suggestions[suggestion], false)}>
                     <a>{postContent.suggestions[suggestion]}</a>
                 </Link>
             </div>
        )
     }
    
    return (
        <>
            <div className="md:flex md:justify-center items-baseline">
                <div className="text-sm md:text-base font-bold px-2 py-2">
                    Tags
                </div>
                {tagHtml}
            </div>

            <div className="text-sm md:text-base">
                <pre>
                    <code className="language-java">
                        {postContent.content}
                    </code>
                </pre>
            </div>

            <div className="mt-10 text-lg md:text-xl">Similar Questions</div>
            <div className="text-sm md:text-base">
                {suggestionsHtml}
            </div>
        </>
    )
}

export default PostContentUI