import { MenuItem } from '../../../model/MenuItem'
import fetch from 'isomorphic-unfetch'
import { slug, unslug } from '../../../util/url'
import { MENU } from '../../../data/menu'
import PageResponse from '../../../model/PageResponse'

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
		difficulty: string
		problem: string
	}
}
function generatePaths(menu: MenuItem[]): Path[] {
	let paths = []
	menu.forEach(menuItem => {
		if(menuItem.problem) {
			paths.push({
				params: {
					difficulty: menuItem.problem,
					problem: slug(menuItem.title)
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
	const sourceCode = unslug(context.params.problem)
	const difficulty = context.params.difficulty
	const codeUrl = "https://raw.githubusercontent.com/vchoudhari45/codingcargo/master/src/main/java/com/vc/"+difficulty+"/"+sourceCode+".java"
	const resCode = await fetch(codeUrl)
	const textCode = await resCode.text()
	const replacedHtml = textCode.replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/'/g, "&#x27;").replace(/"/g, "&quot;").replace(/\//g, "&#x2F;")

	const codePullRequestUrl = "https://github.com/vchoudhari45/codingcargo/edit/master/src/main/java/com/vc/"+difficulty+"/"+sourceCode+".java"
	const url = "https://raw.githubusercontent.com/vchoudhari45/codingcargo/master/src/main/java/com/vc/docs/md/"+difficulty+"/"+context.params.problem+".md"
	const res = await fetch(url)
	const text = (await res.text()).replace("####CODE_PLACEHOLDER####", replacedHtml).replace("####LINK_PLACEHOLDER####", codePullRequestUrl)

	const title = unslug(context.params.problem, ' ')
	const selected = {title: title}
	return {
		 props: { 
			content: text,
			selected: selected
		}
	} 
}

export default Post