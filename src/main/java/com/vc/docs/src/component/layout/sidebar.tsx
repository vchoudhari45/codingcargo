import SearchBox from './searchBox'
import Menu from './menu'

const Sidebar: React.FC = () => {
	return (
		<aside className="jsx-867702785 sidebar fixed">
			<div className="jsx-867702785 sidebar-search">
				<SearchBox />
			</div>

			<div className="jsx-867702785 sidebar-content">
				<Menu />
			</div>
		</aside>
	)							
}

export default Sidebar