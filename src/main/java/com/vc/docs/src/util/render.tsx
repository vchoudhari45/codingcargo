import { MenuItem } from '../model/MenuItem'
import { useState } from 'react'

interface RenderMenuResponse {
	prev: MenuItem
	next: MenuItem
	menuHtml: JSX.Element
}

//DFS
export default function renderMenu(data: MenuItem[], selected: MenuItem, depth: number): RenderMenuResponse {
	let prev = null
	let next = null
	let menuHtml = []

	for(var i = 0; i < data.length; i++) {
		const menuItem = data[i]
		
		if(menuItem.heading) {
			const childrenHtml = renderMenu(menuItem.menuItems, selected, depth)
			
			/** Start: Assign prev & next */
				let found = false
				if(prev == null && childrenHtml.prev != null) {
					prev = childrenHtml.prev
					found = true
				}
				if(next == null && childrenHtml.next != null) {
					next = childrenHtml.next 
					found = true 
				}
				if(found && prev == null) {
					if(i - 1 >= 0) {
						prev = data[i - 1]
						while(prev.menuItems != null) {
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
					}
				}
				if(found && next == null) {
					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							next = next.menuItems[0]
						}
					}
				}
			/** End: Assign prev & next */

			menuHtml.push(
				<div className="jsx-3875994729 heading">
					<h4 className="jsx-3875994729">{menuItem.title}</h4>
					{childrenHtml.menuHtml}
				</div>
		  )
		}
		else {
			if(menuItem.menuItems != null) {
				const childrenHtml = renderMenu(menuItem.menuItems, selected, depth + 1)

				/** Start: Assign prev & next */
				let found = false
				if(prev == null && childrenHtml.prev != null) {
					prev = childrenHtml.prev
					found = true
				}
				if(next == null && childrenHtml.next != null) {
					next = childrenHtml.next 
					found = true 
				}
				if(found && prev == null) {
					if(i - 1 >= 0) {
						prev = data[i - 1]
						while(prev.menuItems != null) {
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
					}
				}
				if(found && next == null) {
					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							next = next.menuItems[0]
						}
					}
				}
				/** End: Assign prev & next */

				const [isCategoryOpen, setCategoryOpen] = useState(menuItem.open != null ? menuItem.open : false)
				menuHtml.push(
					<div className={"jsx-2502836651 category level-" + (depth + 1) + (isCategoryOpen ? " open" : "") + (found ? " selected" : "")}>
						<a className="jsx-2502836651 label" onClick={() => { setCategoryOpen(!isCategoryOpen) }}>
							<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" strokeLinecap="square" />
							</svg>
							{menuItem.title}
						</a>
						<div className="jsx-2502836651 posts">{childrenHtml.menuHtml}</div>
					</div>
				)
			}
			else {
				/** Start: Assign prev & next */
				if(selected.title === menuItem.title) {
					if(i - 1 >= 0) {
						prev = data[i - 1]
						while(prev.menuItems != null) {
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
					}
					else {
						prev = null
					}

					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							next = next.menuItems[0]
						}
					}
					else {
						next = null
					}
				}
				/** End: Assign prev & next */

				const [isMenuItemSelected, setIsMenuItemSelected] = useState(false)
				menuHtml.push(
					<div className={"jsx-616696232 link level-" + depth}>
						<div className={"jsx-3253412043 nav-link" + (selected.title === menuItem.title ? " selected": "")}>
							<a className="jsx-3253412043" href={menuItem.path} onClick={() => { setIsMenuItemSelected(!isMenuItemSelected)}}>{menuItem.title}</a>
						</div>
					</div>
				)
			}
		}
	}
	return {
		prev: prev,
		next: next,
		menuHtml: <>{menuHtml}</>
	}
}