import { useState } from 'react'
import SearchBox from './searchBox'

interface Props {
	menu: JSX.Element
}

const Sidebar: React.FC<Props> = ({menu}) => {
	const[showSearching, setShowSearching] = useState(false)
	return (
		<aside className={"jsx-867702785 sidebar fixed " + (showSearching ? "searching" : "") }>
		  <div className="jsx-867702785 sidebar-search"><SearchBox setShowSearching={setShowSearching} /></div>
			<div className="jsx-867702785 sidebar-content">{menu}</div>
		</aside>
	)							
}

export default Sidebar