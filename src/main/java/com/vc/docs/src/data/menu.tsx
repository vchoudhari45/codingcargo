export const HOMEPAGE = "Getting Started"
export const MENU = [
	{
		title: "Documentation",
		heading: true,
		menuItems: [
			{
				title: HOMEPAGE,
			},
			{
				title: "Basic Features",
				menuItems: [
					{
						title: "Pages",
					},
					{
						title: "Data Fetching",
					},
					{
						title: "Built-in CSS Support",
					}
				]
			},
			{
				title: "Routing",
				menuItems: [
					{
						title: "Introduction",
					},
					{
						title: "Dynamic Routes",
					}
				]
			},
			{
				title: "RoutingLevel3",
				menuItems: [
					{
						title: "Introduction1",
						menuItems: [
							{
								title: "Introduction2",
							},
							{
								title: "Dynamic Routes1",
							}
						]
					},
					{
						title: "Dynamic Routes2",
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
			},
			{
				title: "next/router",
			}
		]
	}
]