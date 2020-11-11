const binarySearch = {
	title: "Binary Search",
	topic: true,
	menuItems: [
		{
			index: 4,
			title: "Median of Two Sorted Arrays",
			problem: "hard",
			company: ["Amazon", "Facebook", "Google", "Microsoft"]
		},
		{
            index: 154,
            title: "Find Minimum in Rotated Sorted Array II",
            problem: "hard",
            company: ["Facebook"]
        },
        {
            index: 354,
            title: "Russian Doll Envelopes",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 410,
            title: "Split Array Largest Sum",
            problem: "hard",
            company: ["Amazon", "Google"]
        },
        {
            index: 644,
            title: "Maximum Average Subarray II",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 668,
            title: "Kth Smallest Number in Multiplication Table",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 719,
            title: "Find K-th Smallest Pair Distance",
            problem: "hard",
            company: ["Google"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default binarySearch