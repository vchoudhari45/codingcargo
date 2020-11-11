const backtracking = {
	title: "Backtracking",
	topic: true,
	menuItems: [
		{
			index: 37,
			title: "Sudoku Solver",
			problem: "hard",
			company: ["Amazon", "Google", "Microsoft"]
		},
		{
				index: 51,
				title: "N Queens",
				problem: "hard",
				company: ["Amazon",  "Microsoft"],
				similar: ["N-Queens II"]
		},
		{
				index: 51,
				title: "N Queens II",
				problem: "hard",
				company: ["Amazon"],
				similar: ["N-Queens"]
		},
		{
                index: 282,
                title: "Expression Add Operators",
                problem: "hard",
                company: ["Facebook", "Google"],
        },
        {
                index: 291,
                title: "Word Pattern II",
                problem: "hard",
                company: ["Amazon"],
        },
        {
                index: 425,
                title: "Word Squares",
                problem: "hard"
        },
        {
                index: 465,
                title: "Optimal Account Balancing",
                problem: "hard",
                company: ["Amazon", "Google"]
        },
        {
                index: 488,
                title: "Zuma Game",
                problem: "hard"
        },
        {
                index: 679,
                title: "Twenty Four Game",
                problem: "hard",
                company: ["Amazon", "Google"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default backtracking