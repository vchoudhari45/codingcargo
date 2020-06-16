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
            <div key={tags[tagIndex]} className="inline-block py-2">
                <Link href={generateTagUrl(postContent.category, tags[tagIndex], false)}>
                    <a className="capitalize mr-2 bg-gray-900 text-gray-500 hover:text-white nounderline text-xs px-3 py-2 rounded-full">{tags[tagIndex]}</a>
                </Link>
            </div>
       )
    }
    
    return (
        <>
            <div className="align-baseline">
                <div className="inline-block pr-2 py-1 text-sm font-bold">Tags</div>
                {tagHtml}
            </div>

            <div>
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