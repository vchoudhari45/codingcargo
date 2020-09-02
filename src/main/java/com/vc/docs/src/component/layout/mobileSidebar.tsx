import { useState } from 'react'
import TrieItem from '../../model/TrieItem'
import SearchBox from './searchBox'

interface Props {
	menu: JSX.Element
	trieData: TrieItem[]
}

const MobileSidebar: React.FC<Props> = ({menu, trieData}) => {
	const [isMobileMenuItemOpen, setIsMobileMenuItemOpen] = useState(false)
	const[showSearching, setShowSearching] = useState(false)

	return (
		<div className="jsx-249575869 shadow">
			<div className="jsx-1998690184">
				<div className="jsx-567598700 sidebar-search"><SearchBox setShowSearching={setShowSearching}  trieData={trieData} /></div>

				<label className={"jsx-567598700 dropdown-toggle"+ (!showSearching && isMobileMenuItemOpen ? " opened" : "")}>
				  <input type="checkbox" id="dropdown-input" className="jsx-567598700"/>
					<div className="jsx-567598700 docs-select" onClick={() => { setIsMobileMenuItemOpen(!isMobileMenuItemOpen) }}>
						<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" strokeLinecap="square" />
						</svg>
						Menu
					</div>
				</label>

				<div className="jsx-567598700 docs-dropdown">
					<div className="jsx-1998690184">
						<nav className="jsx-567598700">{menu}</nav>
					</div>
				</div>
			</div>
		</div>
	)
}

export default MobileSidebar