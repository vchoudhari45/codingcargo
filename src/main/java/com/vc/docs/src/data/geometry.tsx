const geometry = {
	title: "Geometry",
	topic: true,
	menuItems: [
		{
			index: 587,
			title: "Erect the Fence",
			problem: "hard",
			company: ["Google"]
		},
		{
            index: 1610,
            title: "Maximum Number of Visible Points",
            problem: "hard",
            company: ["Google"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default geometry