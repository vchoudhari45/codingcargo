import CategoryItem from './categoryItem'

const categoryItems = [
	{
		level:2,
		name: "Getting Started",
		menuItems:[
			{ name: "Getting Started", url: "/docs/getting-started" }
		]
	},
	{
		level:2,
		name: "Basic Features",
		menuItems:[
			{ name: "Pages", url: "/docs/basic-features/pages" },
			{ name: "Data fetching", url: "/docs/basic-features/data-fetching" }
		]
	},
	{
		level:2,
		name: "Routing",
		menuItems:[
			{ name: "Introduction", url: "/docs/routing/introduction" },
			{ name: "Dynamic Routes", url: "/docs/routing/dynamic-routes" }
		]
	},
	{
		level:2,
		name: "Deployment",
		menuItems:[
			{ name: "Deployment", url: "/docs/deployment" }
		]
	}
]

const menu: React.FC = () => {
	const categoryItemHtml = categoryItems.map(categoryItem => {
		return <CategoryItem key={categoryItem.name} level={categoryItem.level} menuItems={categoryItem.menuItems} name={categoryItem.name} />
	})

	return (
		<div className="jsx-3875994729 heading">
				<h4 className="jsx-3875994729">Documentation</h4>
				<div className="jsx-3875994729">
					{categoryItemHtml}
				</div>
		</div>
	)
}

export default menu;