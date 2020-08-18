import Sidebar from '../component/layout/sidebar'
import MobileSidebar from '../component/layout/mobileSidebar'
import { MenuItem } from '../model/MenuItem'

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
	metadata: "Getting Started",
	main: <>
					<h1>Getting Started</h1>
					<p>Welcome to CodingCargo.com, and add your .md content here from github so that you can have an option to edit the .md file and that it</p>	
				</>
}

export default function Home() {
  return (
		<>
			<MobileSidebar menu={response.sidebar} selected={response.menu} />
			<div className="jsx-1998690184">
				<div className="jsx-1294800792 content">
					<Sidebar menu={response.sidebar} selected={response.menu} />
					<div className="container">
						<div className="jsx-29590182 docs">
							
							<div className="jsx-29590182 docs-content">

							</div>

							<div className="jsx-29590182 page-nav">
								<a href="/docs/getting-started" className="jsx-4279592588 btn fw4 no-drag">
										<span className="jsx-113938279">
												<svg viewBox="0 0 24 24" width="24" height="24">
														<g fill="#0070f3">
																<path fill="#0070f3" d="M14,17.414l-4.707-4.707c-0.391-0.391-0.391-1.023,0-1.414L14,6.586L15.414,8l-4,4l4,4L14,17.414z" />
														</g>
												</svg>
										</span>Getting Started
								</a>

								<a href="/docs/basic-features/data-fetching" className="jsx-4279592588 btn fw4 no-drag">
										Data fetching
										<span className="jsx-3578282791">
												<svg width="24" height="24" viewBox="0 0 24 24">
														<g fill="#0070f3">
																<path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z" />
														</g>
												</svg>
										</span>
								</a>
							</div>

							<footer className="jsx-29590182">
									<a href="https://github.com/vercel/next.js/edit/canary/docs/basic-features/pages.md" target="_blank" rel="noopener noreferrer" className="jsx-29590182">Edit this page on GitHub</a>
							</footer>
							
						</div>
					</div>
				</div>
			</div>
		</>
  )
}
