import SearchBox from './searchBox'
import Menu from './menu'
import { MenuItem } from '../../model/MenuItem'

interface Props {
	menu: MenuItem[]
	selected: MenuItem
}

const Sidebar: React.FC<Props> = ({menu, selected}) => {
	return (
		<aside className="jsx-867702785 sidebar fixed">
			<div className="jsx-867702785 sidebar-search">
				<SearchBox />
			</div>

			<div className="jsx-867702785 sidebar-content">
				<Menu data={menu} selected={selected} />
			</div>
		</aside>
	)							
}

export default Sidebar