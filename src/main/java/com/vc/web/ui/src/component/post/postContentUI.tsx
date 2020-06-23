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
            <div key={tags[tagIndex]}>
                <Link href="/list/[category]/[tag]/" as={generateTagUrl(postContent.category, tags[tagIndex], false)} prefetch={false}>
                    <a className="capitalize
                       md:bg-gray-900 md:text-gray-500 md:hover:text-white md:rounded-lg md:px-4 md:py-1 md:mr-2">{tags[tagIndex]}</a>
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
    
    const postDescriptionWithInput = postContent.description.split("\n")
    const inputOutput: JSX.Element[] = []
    for (let i = 3; i < postDescriptionWithInput.length; i+=2) {
        inputOutput.push(
            <>
                <br /><br />
                Input&nbsp;&nbsp;:&nbsp;{postDescriptionWithInput[i]}<br />
                Ouput:&nbsp;{postDescriptionWithInput[i + 1]}
            </>
        )
    }

    return (
        <>
            <>
                <div className="text-base md:text-lg capitalize leading-relaxed font-medium mb-2">Tags</div>
                <div className="text-sm text-gray-900 leading-snug md:flex md:justify-start items-baseline tracking-tight">{tagHtml}</div>
            </>

            <div className="mt-8">
                <div className="text-base md:text-lg capitalize leading-relaxed font-medium mb-1">Problem Statement</div>
                <div className="text-sm md:text-base text-gray-900 leading-snug">
                    {postDescriptionWithInput[0]}
                </div>
            </div>

            <div className="mt-8">
                <div className="text-base md:text-lg capitalize leading-relaxed font-medium mb-1">Example</div>
                <div className="text-sm md:text-base text-gray-900">
                    Input&nbsp;&nbsp;:&nbsp;{postDescriptionWithInput[1]}<br />
                    Ouput:&nbsp;{postDescriptionWithInput[2]}
                    {
                        postDescriptionWithInput.length > 3 
                        ? <>{inputOutput}</>
                        : ""
                    }
                </div>
            </div>

            <div className="mt-8">
                <div className="text-base md:text-lg capitalize leading-relaxed font-medium mb-1">Solution</div>
                <div className="text-sm border border-gray-100 shadow rounded-lg">
                    <pre>
                        <code className="language-java">
                            {postContent.content}
                        </code>
                    </pre>
                </div>
            </div>

            {
                suggestionsHtml.length > 0
                ?   
                    <div className="mt-8">
                        <div className="text-base md:text-lg capitalize leading-relaxed font-medium mb-1">Similar Questions</div>
                        <div className="text-sm md:text-base text-gray-900">{suggestionsHtml}</div>
                    </div>
                :   ""
            }
        </>
    )
}

export default PostContentUI