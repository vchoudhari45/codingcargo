import SearchBox from './searchBox'

interface Props {
	menu: JSX.Element
}

const Sidebar: React.FC<Props> = ({menu}) => {
	return (
		<aside className="jsx-867702785 sidebar fixed">
		  <div className="jsx-867702785 sidebar-search"><SearchBox /></div>
			<div className="jsx-867702785 sidebar-content">{menu}</div>
		</aside>
	)							
}

export default Sidebar