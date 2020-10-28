import { MenuItem } from '../model/MenuItem'
import Header from './layout/header'
import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import renderMenu from '../util/render'
import Main from '../component/layout/main'
import { MENU } from '../data/menu'
import { useRef } from 'react'

interface Props {
	content: string,
	selected: MenuItem,
}

const DefaultLayout: React.FC<Props> = ({ content, selected } : Props) => {
	const itemRef = useRef<HTMLInputElement>()
	const renderMenuResponse = renderMenu(MENU, selected, 1, itemRef, "1")

	return (
		<div>
			<Header />
			<div className="jsx-4169323174">
				<MobileSidebar menu={renderMenuResponse.menuHtml} trieData={renderMenuResponse.menuData} />
				<div className="jsx-1998690184">
					<div className="jsx-1294800792 content">
						<Sidebar menu={renderMenuResponse.menuHtml} trieData={renderMenuResponse.menuData} />
						<Main content={content} prev={renderMenuResponse.prev} current={selected} next={renderMenuResponse.next} />
					</div>
				</div>
			</div>
		</div>
  )
}
export default DefaultLayout