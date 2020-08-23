import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import renderMenu from '../util/render'
import Main from '../component/layout/main'
import {menu} from '../data/menu'
import { MenuItem } from '../model/MenuItem'
import fetch from 'isomorphic-unfetch';

interface Props {
	content: string,
	selected: MenuItem,
}

function Post({selected, content}: Props) {
	const renderMenuResponse = renderMenu(menu, selected, 1)
  return (
		<>
			<MobileSidebar menu={renderMenuResponse.menuHtml} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={renderMenuResponse.menuHtml} />
					<Main content={content} prev={renderMenuResponse.prev} current={selected} next={renderMenuResponse.next} />
				</div>
			</div>
		</>
  )
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