import { useState } from 'react'

interface MenuProps {
	name: string 
	url: string
}

interface Props {
	level: number
	name: string
	menuItems: MenuProps[]
}

const categoryItem: React.FC<Props> = ({level, menuItems, name}: Props) => {
	
	const [isCategoryOpen, setCategoryOpen] = useState(false) 
	const [isCategorySelected, setCategorySelected] = useState(false)

	const menuItemHtml = menuItems.map(menuItem => {
		const [isMenuItemSelected, setIsMenuItemSelected] = useState(false)
		return (
			<div key={menuItem.name} className={"jsx-616696232 link level-" + (level + 1)}>
				<div className={"jsx-3253412043 nav-link " + (isMenuItemSelected ? "selected": "")} onClick={() => { setIsMenuItemSelected(!isMenuItemSelected); setCategorySelected(!isCategorySelected) }}>
					<a className="jsx-3253412043" href={menuItem.url}>{menuItem.name}</a>
				</div>
			</div>
		)
	})

	return (
		menuItems.length == 1 ? <>{menuItemHtml} </> : 
		<div className={"jsx-2502836651 category level-2 " + (isCategoryOpen ? "open" : "") +" "+(isCategorySelected ? "selected" : "")} onClick={() => { setCategoryOpen(!isCategoryOpen) }}>
			<a className="jsx-2502836651 label">
				<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
					<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" strokeLinecap="square" />
				</svg>
				{name}
			</a>
			<div className="jsx-2502836651 posts">{menuItemHtml}</div>
		</div>
	)

}

export default categoryItem