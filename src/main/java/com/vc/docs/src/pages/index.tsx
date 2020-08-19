import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import { MenuItem } from '../model/MenuItem'
import Main from '../component/layout/main'
import { useState } from 'react'

interface Props {
	sidebar: MenuItem[],
	menuItem: MenuItem,
	metadata: string,
	main: JSX.Element
}

const menu = [
	{
		title: "Documentation",
		heading: true,

		menuItems: [
			{
				title: "Getting Started",
				path: "/docs/getting-started.md"
			},
			{
				title: "Basic Features",
				open: true,
				menuItems: [
					{
						title: "Pages",
						path: "/docs/basic-features/getting-started.md"
					},
					{
						title: "Data Fetching",
						path: "/docs/basic-features/data-fetching.md"
					},
					{
						title: "Built-in CSS Support",
						path: "/docs/basic-features/built-in-css-support.md"
					}
				]
			},
			{
				title: "Routing",
				menuItems: [
					{
						title: "Introduction",
						path: "/docs/basic-features/built-in-css-support.md"
					},
					{
						title: "Dynamic Routes",
						path: "/docs/basic-features/dynamic-routes.md"
					}
				]
			}
		]
	},
	{
		title: "API Reference",
		heading: true,
		menuItems: [
			{
				title: "CLI",
				path: "/docs/api-reference.md"
			},
			{
				title: "next/router",
				path: "/docs/api-reference/next/router.md"
			}
		]
	}
]

//This is Input
const selected = {
	title: "next/router",
	path: "/docs/basic-features/getting-started.md"
}
const metadata =  "Getting Started"

export default function Home() {
	const res = renderMenu(menu, selected, 1)
	const prevTitle = res.prev != null ? res.prev.title : "NULL"
	const nextTitle = res.next != null ? res.next.title : "NULL"
	console.log("res: "+prevTitle+" "+nextTitle)
	return (
		<>
			<MobileSidebar menu={res.menuHtml} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={res.menuHtml} />
					<Main prev={res.prev} current={selected} next={res.next} />
				</div>
			</div>
		</>
  )
}

interface RenderMenuResponse {
	prev: MenuItem
	next: MenuItem
	menuHtml: JSX.Element
}

//DFS
function renderMenu(data: MenuItem[], selected: MenuItem, depth: number): RenderMenuResponse {
	let prev = null
	let next = null
	let menuHtml = []

	for(var i = 0; i < data.length; i++) {
		const menuItem = data[i]
		const [isMenuItemSelected, setIsMenuItemSelected] = useState(false)
		const [isCategoryOpen, setCategoryOpen] = useState(menuItem.open != null ? menuItem.open : false)
		
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
							console.log("Assiging Prev: "+prev.title+":"+prev.menuItems[prev.menuItems.length - 1].title)
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
					}
				}
				if(found && next == null) {
					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							console.log("Assiging Next: "+next.title+":"+next.menuItems[0].title)
							next = next.menuItems[0]
						}
					}
				}
			/** End: Assign prev & next */

			menuHtml.push(
				<>
					<h4 className="jsx-3875994729">{menuItem.title}</h4>
					{childrenHtml.menuHtml}
				</>
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
							console.log("Assiging Prev: "+prev.title+":"+prev.menuItems[prev.menuItems.length - 1].title)
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
						console.log("Found : "+prev.title)
					}
				}
				if(found && next == null) {
					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							console.log("Assiging Next: "+next.title+":"+next.menuItems[0].title)
							next = next.menuItems[0]
						}
					}
				}
				/** End: Assign prev & next */

				menuHtml.push(
					<div className={"jsx-2502836651 category level-" + (depth + 1) + (isCategoryOpen ? " open" : "")} onClick={() => { setCategoryOpen(!isCategoryOpen) }}>
						<a className="jsx-2502836651 label">
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
							console.log("Assiging Prev: "+prev.menuItems[prev.menuItems.length - 1].title)
							prev = prev.menuItems[prev.menuItems.length - 1]
						}
					}
					else {
						console.log("Assiging prev to null")
						prev = null
					}

					if(i + 1 < data.length) {
						next = data[i + 1]
						while(next.menuItems != null) {
							console.log("Assiging Next: "+next.menuItems[0].title)
							next = next.menuItems[0]
						}
					}
					else {
						console.log("Assiging next to null")
						next = null
					}
				}
				/** End: Assign prev & next */

				menuHtml.push(
					<div className={"jsx-616696232 link level-" + depth}>
						<div className={"jsx-3253412043 nav-link " + (selected.title === menuItem.title ? "selected": "")} onClick={() => { setIsMenuItemSelected(!isMenuItemSelected)}}>
							<a className="jsx-3253412043" href={menuItem.path}>{menuItem.title}</a>
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
