const dynamicProgramming = {
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
					company: ["Amazon", "Facebook", "Google", "Microsoft"],
					similar: ["Wildcard Matching"]
				},
				{
					index: 44,
					title: "Wildcard Matching",
					problem: "hard",
					company: ["Amazon", "Facebook", "Microsoft"],
					similar: ["Regular Expression Matching"]
				}
			]
		}
	]
}

export default dynamicProgramming