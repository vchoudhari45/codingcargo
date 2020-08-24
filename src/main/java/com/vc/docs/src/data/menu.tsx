export const menu = [
	{
		title: "Documentation",
		heading: true,
		menuItems: [
			{
				title: "Getting Started",
			},
			{
				title: "Basic Features",
				open: true,
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
						title: "Introduction",
						menuItems: [
							{
								title: "Introduction1",
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
