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
            <div key={tags[tagIndex]} className="px-1 py-2">
                <Link href="/list/[category]/[tag]/" as={generateTagUrl(postContent.category, tags[tagIndex], false)} prefetch={false}>
                    <a className="capitalize hover:underline nounderline text-sm md:text-base text-gray-700 md:tracking-tight">{tags[tagIndex]}</a>
                </Link>
            </div>
       )
    }

    const suggestionsHtml: JSX.Element[] = []
    for (const suggestion in postContent.suggestions) {
        suggestionsHtml.push(
             <div key={postContent.suggestions[suggestion]} className="capitalize hover:underline nounderline text-sm md:text-base leading-relaxed">
                 <Link href="/post/[postTitle]/" as={generatePostUrl(postContent.suggestions[suggestion], false)} prefetch={false}>
                     <a>{postContent.suggestions[suggestion]}</a>
                 </Link>
             </div>
        )
     }
    
    return (
        <>
            <div className="md:flex md:justify-start items-baseline">
                <div className="text-sm md:text-base font-bold px-1 py-2 tracking-tight">
                    Tags
                </div>
                {tagHtml}
            </div>

            <div className="text-sm md:text-base">
                {postContent.description}
            </div>

            <div className="text-sm md:text-base">
                <pre>
                    <code className="language-java">
                        {postContent.content}
                    </code>
                </pre>
            </div>

            {
                suggestionsHtml.length > 0
                ?   <>
                        <div className="mt-10 text-lg md:text-xl">Similar Questions</div>
                            <div className="text-sm md:text-base">
                            {suggestionsHtml}
                        </div>
                    </>
                :   ""
            }
        </>
    )
}

export default PostContentUI