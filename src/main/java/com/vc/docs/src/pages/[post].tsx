import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'

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
			{ params: { post: "Getting Started" } },
			{ params: { post: "Data Fetching" } },
			{ params: { post: "Pages" } }
    ],
    fallback: false
  }
}

export async function getStaticProps({params}) {
	const selected = {title: params.post}
	console.log("Printing :"+selected)

	const url = "https://raw.githubusercontent.com/vchoudhari45/leetcode/master/src/main/java/com/vc/docs/md/GettingStarted.md"
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