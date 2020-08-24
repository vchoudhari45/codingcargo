import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { unslug } from '../util/url'

interface Props {
	content: string,
	selected: MenuItem,
}

function Post({selected, content}: Props) {
	return {
		content: content,
		selected: selected
	}
}

export async function getStaticPaths() {
  return {
    paths: [
			{ params: { post: "getting-started" } },
			{ params: { post: "data-fetching" } },
			{ params: { post: "pages" } }
    ],
    fallback: false
  }
}

export async function getStaticProps({params}) {
	const title = unslug(params.post)
	const selected = {title: title}
	const url = "https://raw.githubusercontent.com/vchoudhari45/leetcode/master/src/main/java/com/vc/docs/md/getting-started.md"
	const res = await fetch(url)
	const text = await res.text()
	return {
		 props: { 
			content: text,
			selected: selected,
		}
	} 
}

export default Post