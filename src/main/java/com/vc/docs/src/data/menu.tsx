import { MenuItem } from "../model/MenuItem"

export const HOMEPAGE = "Getting Started"
export const BASEURL = "https://www.codingcargo.com/"
export const SITENAME = "Coding Cargo"
export const TWITTER_HANDLE = "@coding_cargo"
export const MENU: MenuItem[] = [
	{
		title: "Index",
		heading: true,
		menuItems: [
			{
				title: HOMEPAGE,
				post: true
			},
			{
				title: "Binary Search",
				topic: true,
				menuItems: [
					{
						title: "What is Binary Search?",
						post: true
					},
					{
						title: "Binary Search problem Set",
						topic: true,
						menuItems: [
							{
								title: "Median of Two Sorted Arrays",
								problem: "hard"
							},
							{
								title: "Maximum Gap",
								problem: "hard"
							},
							{
								title: "Dungeon Game",
								problem: "hard"
							}
						]
					}
				]
			}
		]
	}
]