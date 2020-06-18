import { Post } from "../../model/Post"
import Link from "next/link"
import { generatePostUrl } from "../../util/urlUtil"

interface _PostProps {
    post: Post
}
const _Post = (props: _PostProps) => {
    const url = generatePostUrl(props.post.title, false)
    return (
        <div className="rounded mb-8 mt-1">
            <Link href="/post/[postTitle]/" as={url} prefetch={false}>
                <a className="text-base md:text-lg capitalize leading-relaxed tracking-wide font-medium no-underline hover:underline">{props.post.title}</a>
            </Link>
            <div className="text-sm md:text-base text-gray-900 leading-snug">{props.post.description}</div>
            <Link href="/post/[postTitle]/" as={url} prefetch={false}>
                <a className="flex justify-start items-baseline tracking-tight text-xs md:text-sm text-gray-700 mt-2 no-underline hover:underline">
                    Read More...
                </a>
            </Link>
        </div>
    )
}

export default _Post