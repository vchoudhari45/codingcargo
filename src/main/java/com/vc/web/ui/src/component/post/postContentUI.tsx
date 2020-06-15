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
            <Link key={tags[tagIndex]} href={generateTagUrl(postContent.category, tags[tagIndex], false)}>
                <a className="capitalize mr-2 nounderline hover:underline">{tags[tagIndex]}</a>
            </Link>
       )
    }
    
    return (
        <>
           {/* 
            Needs to be fixed
            <div className="flex justify-start items-baseline text-sm text-gray-700 mb-6 whitespace-no-wrap">
                <div className="text-gray-900 font-bold mr-2">Tags</div>
                <div className="whitespace-no-wrap">{tagHtml} </div>
            </div> */}
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