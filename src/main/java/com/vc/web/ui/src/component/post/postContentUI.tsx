import Link from 'next/link'
import { PostContent } from '../../model/PostContent'
import { generateTagUrl } from '../../util/urlUtil'
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
            <div key={tags[tagIndex]} className="px-0 md:px-2 py-2">
                <Link href={generateTagUrl(postContent.category, tags[tagIndex], false)}>
                    <a className="capitalize hover:underline nounderline text-sm md:text-base">{tags[tagIndex]}</a>
                </Link>
            </div>
       )
    }
    
    return (
        <>
            <div className="md:flex md:justify-center items-baseline">
                <div className="pr-2 py-2 text-sm md:text-base font-bold">
                    Tags
                </div>
                {tagHtml}
            </div>

            <div className="mt-2 text-sm md:text-base">
                <pre>
                    <code className="language-java">
                        {postContent.content}
                    </code>
                </pre>
            </div>
        </>
    )
}

export default PostContentUI