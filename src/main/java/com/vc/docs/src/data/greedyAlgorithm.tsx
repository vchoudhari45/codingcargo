const greedyAlgorithm = {
	title: "Greedy Algorithm",
	topic: true,
	menuItems: [
		{
			index: 45,
			title: "Jump Game II",
			problem: "hard",
			company: ["Amazon", "Google", "Microsoft"],
			similar: ["Jump Game", "Jump Game III"]
		},
		{
            index: 68,
            title: "Text Justification",
            problem: "hard",
            company: ["Amazon", "Google"]
        },
        {
            index: 1665,
            title: "Minimum Initial Energy to Finish Tasks",
            problem: "hard"
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default greedyAlgorithm