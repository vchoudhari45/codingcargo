export const menu = [
	{
		title: "Documentation",
		heading: true,

		menuItems: [
			{
				title: "Getting Started",
				path: "/Getting Started"
			},
			{
				title: "Basic Features",
				menuItems: [
					{
						title: "Pages",
						path: "/Pages"
					},
					{
						title: "Data Fetching",
						path: "/Data Fetching"
					},
					{
						title: "Built-in CSS Support",
						path: "/Built-in CSS Support"
					}
				]
			},
			{
				title: "Routing",
				menuItems: [
					{
						title: "Introduction",
						path: "/Introduction"
					},
					{
						title: "Dynamic Routes",
						path: "/Dynamic Routes"
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
								path: "/Introduction1"
							},
							{
								title: "Dynamic Routes1",
								path: "/Dynamic Routes1"
							}
						]
					},
					{
						title: "Dynamic Routes2",
						path: "/Dynamic Routes2"
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
				path: "/CLI"
			},
			{
				title: "next/router",
				path: "/next/router"
			}
		]
	}
]
