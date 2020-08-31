import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { HOMEPAGE } from '../data/menu'
import { slug } from '../util/url'
import PageResponse from '../model/PageResponse'


export default function Home({content, selected, metadata, keywords, robots}: PageResponse) {
	return {
		content: content,
		selected: selected,
		metadata: metadata,
		keywords: keywords,
		robots: robots
	}
}

export async function getStaticProps() {
	const selected = {title: HOMEPAGE}
	const url = "https://raw.githubusercontent.com/vchoudhari45/leetcode/master/src/main/java/com/vc/docs/md/"+slug(HOMEPAGE)+".md"
	const res = await fetch(url)
	const text = await res.text()

	const contentArr = text.split("\n")
	return {
		 props: { 
			content: text,
			selected: selected,
			metadata: contentArr[0],
			keywords: contentArr[1],
			robots: contentArr[2]
		}
	} 	
}
