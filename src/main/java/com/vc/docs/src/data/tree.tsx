const tree = {
	title: "Tree",
	topic: true,
	menuItems: [
		{
			index: 99,
			title: "Recover Binary Search Tree",
			problem: "hard",
			company: ["Amazon", "Google", "Microsoft"]
		},
		{
            index: 124,
            title: "Binary Tree Maximum Path Sum",
            problem: "hard",
            company: ["Amazon", "Facebook", "Google", "Microsoft"]
        },
        {
            index: 272,
            title: "Closest Binary Search Tree Value II",
            problem: "hard",
            company: ["Amazon", "Facebook"]
        },
        {
            index: 297,
            title: "Serialize and Deserialize Binary Tree",
            problem: "hard",
            company: ["Amazon", "Facebook", "Google", "Microsoft"]
        },
        {
            index: 428,
            title: "Serialize and Deserialize N ary Tree",
            problem: "hard",
            company: ["Amazon", "Google", "Microsoft"]
        },
        {
            index: 431,
            title: "Encode N ary Tree to Binary Tree",
            problem: "hard"
        },
        {
            index: 1597,
            title: "Build Binary Expression Tree From Infix Expression",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 1649,
            title: "Create Sorted Array through Instructions",
            problem: "hard"
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default tree