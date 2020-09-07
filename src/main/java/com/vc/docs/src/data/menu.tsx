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
						title: "What is Binary Search",
						post: true
					},
					{
						title: "Problem Set",
						topic: true,
						menuItems: [
							{
								index: 4,
                title: "Median of Two Sorted Arrays",
								problem: "hard",
								company: ["Amazon", "Facebook", "Google", "Microsoft"]
							}
						]
					}
				]
			},
			{
			    title: "Dynamic Programming",
			    topic: true,
			    menuItems: [
			        {
			            title: "What is Dynamic Programming",
			            post: true
			        },
			        {
			            title: "Problem Set",
			            topic: true,
			            menuItems: [
			                {
			                    index: 10,
			                    title: "Regular Expression Matching",
			                    problem: "hard",
			                    company: ["Amazon", "Facebook", "Google", "Microsoft"]
			                }
			            ]
			        }
			    ]
			},
			{
                title: "Priority Queue",
                topic: true,
                menuItems: [
                    {
                        title: "What is Priority Queue",
                        post: true
                    },
                    {
                        title: "Problem Set",
                        topic: true,
                        menuItems: [
                            {
                                index: 23,
                                title: "Merge k Sorted Lists",
                                problem: "hard",
                                company: ["Amazon", "Facebook", "Google", "Microsoft"]
                            }
                        ]
                    }
                ]
            },
            {
                title: "Linked List",
                topic: true,
                menuItems: [
                    {
                        title: "What is Linked List",
                        post: true
                    },
                    {
                        title: "Problem Set",
                        topic: true,
                        menuItems: [
                            {
                                index: 25,
                                title: "Reverse Nodes in k-Group",
                                problem: "hard",
                                company: ["Amazon", "Facebook", "Microsoft"]
                            }
                        ]
                    }
                ]
            }
		]
	}
]