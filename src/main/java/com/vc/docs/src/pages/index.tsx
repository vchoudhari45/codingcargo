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

const response = {
	sidebar: menu,
	menu: {
		title: "Pages",
		path: "/docs/basic-features/getting-started.md"
	},
	metadata: "Getting Started"
}

export default function Home() {
	const res = renderMenu(response.sidebar, response.menu, 1)
  return (
		<>
			<MobileSidebar menu={res.menuHtml} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={res.menuHtml} />
					<Main prev={null} current={response.menu} next={response.menu} />
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
	let prev = {title: ""}
	let next = {title: ""}

	const menuHtml = data.map(menuItem => {
		const [isMenuItemSelected, setIsMenuItemSelected] = useState(false)
		const [isCategoryOpen, setCategoryOpen] = useState(menuItem.open != null ? menuItem.open : false)

		if(menuItem.heading) {
			const childrenHtml = renderMenu(menuItem.menuItems, selected, depth)
			return (
				<>
				<h4 className="jsx-3875994729">{menuItem.title}</h4>
				{childrenHtml.menuHtml}
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
						<div className="jsx-2502836651 posts">{childrenHtml.menuHtml}</div>
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
	return {
		prev: prev,
		next: next,
		menuHtml: <>{menuHtml}</>
	}
}
