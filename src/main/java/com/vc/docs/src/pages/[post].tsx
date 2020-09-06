import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { slug, unslug } from '../util/url'
import { MENU } from '../data/menu'
import PageResponse from '../model/PageResponse'

function Post({selected, content}: PageResponse) {
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
		if(menuItem.post) {
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
	paths.push({
		params: {
			post: 'facebook-problem-set'
		}
	})
	paths.push({
		params: {
			post: 'amazon-problem-set'
		}
	})
	paths.push({
		params: {
			post: 'all-problem-set'
		}
	})
	paths.push({
		params: {
			post: 'google-problem-set'
		}
	})
	paths.push({
		params: {
			post: 'microsoft-problem-set'
		}
	})
	return paths
}

export async function getStaticProps(context) {
	const url = "https://raw.githubusercontent.com/vchoudhari45/codingcargo/master/src/main/java/com/vc/docs/md/posts/"+context.params.post+".md"
	const res = await fetch(url)
	const text = await res.text()
	const title = unslug(context.params.post, ' ')
	const selected = {title: title}
	return {
		 props: { 
			content: text,
			selected: selected
		}
	} 
}

export default Post