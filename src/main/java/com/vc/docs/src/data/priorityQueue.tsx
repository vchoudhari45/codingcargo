const priorityQueue = {
	title: "Priority Queue",
	topic: true,
	menuItems: [
		{
			index: 23,
			title: "Merge k Sorted Lists",
			problem: "hard",
			company: ["Amazon", "Facebook", "Google", "Microsoft"]
		},
		{
            index: 295,
            title: "Median Finder",
            problem: "hard",
            company: ["Amazon", "Facebook", "Google", "Microsoft"]
        },
        {
            index: 358,
            title: "Rearrange String k Distance Apart",
            problem: "hard",
            company: ["Facebook", "Microsoft"]
        },
        {
            index: 407,
            title: "Trapping Rain Water II",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 502,
            title: "IPO",
            problem: "hard"
        },
        {
            index: 568,
            title: "Maximum Vacation Days",
            problem: "hard",
            company: ["Google", "Facebook"]
        },
        {
            index: 630,
            title: "Course Schedule III",
            problem: "hard",
            company: ["Google", "Microsoft"]
        },
        {
            index: 632,
            title: "Smallest Range Covering Elements from K Lists",
            problem: "hard",
            company: ["Amazon"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default priorityQueue