import { MenuItem } from '../../model/MenuItem'
import { useState } from 'react'

interface Props {
	data: MenuItem[]
	selected: MenuItem
}

const menu: React.FC<Props> = ({data, selected}: Props) => {
	return (
		<div className="jsx-3875994729 heading">
			{ renderMenu(data, selected, 1) }
		</div>	
	)
}

//DFS
function renderMenu(data: MenuItem[], selected: MenuItem, depth: number) {
	const menuHtml = data.map(menuItem => {
		const [isMenuItemSelected, setIsMenuItemSelected] = useState(false)
		const [isCategoryOpen, setCategoryOpen] = useState(menuItem.open != null ? menuItem.open : false)

		if(menuItem.heading) {
			const childrenHtml = renderMenu(menuItem.menuItems, selected, depth)
			return (
				<>
				<h4 className="jsx-3875994729">{menuItem.title}</h4>
				{childrenHtml}
				</>
			)
		}
		else {
			if(menuItem.menuItems != null) {
				const childrenHtml = renderMenu(menuItem.menuItems, selected, depth + 1)
				return (
					<div className={"jsx-2502836651 category level-" + (depth + 1) + (isCategoryOpen ? " open" : "")} onClick={() => { setCategoryOpen(!isCategoryOpen) }}>
						<a className="jsx-2502836651 label">
							<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" strokeLinecap="square" />
							</svg>
							{menuItem.title}
						</a>
						<div className="jsx-2502836651 posts">{childrenHtml}</div>
					</div>
				)
			}
			else {
				return (
					<div className={"jsx-616696232 link level-" + depth}>
						<div className={"jsx-3253412043 nav-link " + (selected.title === menuItem.title ? "selected": "")} onClick={() => { setIsMenuItemSelected(!isMenuItemSelected)}}>
							<a className="jsx-3253412043" href={menuItem.path}>{menuItem.title}</a>
						</div>
					</div>
				)
			}
		}
	})
	return menuHtml
}

export default menu;