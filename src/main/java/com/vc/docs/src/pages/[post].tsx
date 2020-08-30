import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { slug, unslug } from '../util/url'
import { MENU } from '../data/menu'

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
	const paths = generatePaths(MENU)
	return {
    paths: paths,
    fallback: false
  }
}

interface Path {
	params: {
		post: string
	}
}
function generatePaths(menu: MenuItem[]): Path[] {
	let paths = []
	menu.forEach(menuItem => {
		if(menuItem.heading == null || menuItem.heading != true) {
			paths.push({
				params: {
					post: slug(menuItem.title)
				}
			})
		} 
		if(menuItem.menuItems != null && menuItem.menuItems.length > 0) {
			paths.push(...generatePaths(menuItem.menuItems))
		}
	})
	return paths
}

export async function getStaticProps(context) {
	const title = unslug(context.params.post)
	const selected = {title: title}
	const url = "https://raw.githubusercontent.com/vchoudhari45/leetcode/master/src/main/java/com/vc/docs/md/"+context.params.post+".md"
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