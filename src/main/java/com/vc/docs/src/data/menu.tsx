export const menu = [
	{
		title: "Documentation",
		heading: true,

		menuItems: [
			{
				title: "Getting Started",
				path: "/"
			},
			{
				title: "Basic Features",
				menuItems: [
					{
						title: "Pages",
						path: "/"
					},
					{
						title: "Data Fetching",
						path: "/"
					},
					{
						title: "Built-in CSS Support",
						path: "/"
					}
				]
			},
			{
				title: "Routing",
				menuItems: [
					{
						title: "Introduction",
						path: "/"
					},
					{
						title: "Dynamic Routes",
						path: "/"
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
								path: "/"
							},
							{
								title: "Dynamic Routes1",
								path: "/"
							}
						]
					},
					{
						title: "Dynamic Routes2",
						path: "/"
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
				path: "/"
			},
			{
				title: "next/router",
				path: "/"
			}
		]
	}
]
