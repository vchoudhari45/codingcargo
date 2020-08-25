import { MenuItem } from '../model/MenuItem'
import Header from './layout/header'
import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import renderMenu from '../util/render'
import Main from '../component/layout/main'
import {menu} from '../data/menu'
import { useEffect, useRef } from 'react'

interface Props {
	content: string,
	selected: MenuItem,
}

const DefaultLayout: React.FC<Props> = ({ content, selected }: Props) => {

	const itemRef = useRef<HTMLInputElement>()
	const renderMenuResponse = renderMenu(menu, selected, 1, itemRef)
	
	useEffect(() => {
		itemRef.current.scrollIntoView()
		window.scrollTo(0, 0)
	}, [])

	return (
			<>
				<Header />
				<div className="jsx-4169323174">
					<MobileSidebar menu={renderMenuResponse.menuHtml} />
					<div className="jsx-1998690184">
						<div className="jsx-1294800792 content">
							<Sidebar menu={renderMenuResponse.menuHtml} />
							<Main content={content} prev={renderMenuResponse.prev} current={selected} next={renderMenuResponse.next} />
						</div>
					</div>
				</div>
			</>
  )
}
export default DefaultLayout