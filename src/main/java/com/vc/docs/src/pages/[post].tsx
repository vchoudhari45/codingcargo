import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import renderMenu from '../util/render'
import Main from '../component/layout/main'
import {menu} from '../data/menu'
import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch'

interface Props {
	menuHtml: JSX.Element
	content: JSX.Element 
	prev: MenuItem,
	selected: MenuItem,
	next: MenuItem
}

function Post({ menuHtml, content, prev, selected, next }: Props) {
  return (
		<>
			<MobileSidebar menu={menuHtml} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={menuHtml} />
					<Main content={content} prev={prev} current={selected} next={next} />
				</div>
			</div>
		</>
  )
}

export async function getStaticPaths() {
  return {
    paths: [
      { params: { post: "GettingStarted" } }
    ],
    fallback: false
  }
}

export async function getStaticProps({params}) {
	console.log("Printing params: "+params)

	const selected = {title: params.post}
	const menuResponse = {menuHtml: <></>, prev: {title: ""}, next: {title: ""}}//renderMenu(menu, {title: params.post}, 1)
	const url = "https://raw.githubusercontent.com/vchoudhari45/leetcode/master/src/main/java/com/vc/docs/md/"+params.post+".md"
	console.log("Printing URL: "+url)
	
	const res = await fetch(url)
	console.log(res)
	const content = await res.json()
		
	console.log(selected)
	console.log(menuResponse.menuHtml)
	console.log(content)

	const response = {
		menuHtml: menuResponse.menuHtml,
		content: content,
		prev : menuResponse.prev,
		selected: selected,
		next : menuResponse.next
	}
  return { props: { response} }
}

export default Post