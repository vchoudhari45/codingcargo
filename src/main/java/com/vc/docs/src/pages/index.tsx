import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { HOMEPAGE } from '../data/menu'
import { slug } from '../util/url'
import PageResponse from '../model/PageResponse'


export default function Home({content, selected}: PageResponse) {
	return {
		content: content,
		selected: selected
	}
}

export async function getStaticProps() {
	const selected = {title: HOMEPAGE}
	const url = "https://raw.githubusercontent.com/vchoudhari45/codingcargo/master/src/main/java/com/vc/docs/md/"+slug(HOMEPAGE)+".md"
	const res = await fetch(url)
	const text = await res.text()
	return {
		 props: { 
			content: text,
			selected: selected
		}
	} 	
}
