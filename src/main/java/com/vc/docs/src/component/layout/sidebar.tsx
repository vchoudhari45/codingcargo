import { useState } from 'react'
import TrieItem from '../../model/TrieItem'
import SearchBox from './searchBox'

interface Props {
	menu: JSX.Element
	trieData: TrieItem[]
}

const Sidebar: React.FC<Props> = ({menu, trieData}) => {
	const[showSearching, setShowSearching] = useState(false)
	return (
		<aside className={"jsx-867702785 sidebar fixed " + (showSearching ? "searching" : "") }>
		  <div className="jsx-867702785 sidebar-search"><SearchBox setShowSearching={setShowSearching} trieData={trieData} /></div>
			<div className="jsx-867702785 sidebar-content">{menu}</div>
		</aside>
	)							
}

export default Sidebar