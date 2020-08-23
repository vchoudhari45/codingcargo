import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import renderMenu from '../util/render'

import Main from '../component/layout/main'
import {menu} from '../data/menu'

//This is Input
const selected = {
	title: "Dynamic Routes1",
	path: "/"
}

//Will be fetched from .md file 
const metadata =  "Getting Started"

export default function Home() {
	const res = renderMenu(menu, selected, 1)
	const prevTitle = res.prev != null ? res.prev.title : "NULL"
	const nextTitle = res.next != null ? res.next.title : "NULL"
	return (
		<>
			<MobileSidebar menu={res.menuHtml} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={res.menuHtml} />
					<Main content={<><h1>This is static h1</h1><p>And this is some static paragraph................. ok working not working working not working working</p></>} prev={res.prev} current={selected} next={res.next} />
				</div>
			</div>
		</>
  )
}