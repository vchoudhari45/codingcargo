const string = {
	title: "String",
	topic: true,
	menuItems: [
		{
			index: 65,
			title: "Valid Number",
			problem: "hard",
			company: ["Amazon", "Facebook", "Google"]
		},
		{
            index: 158,
            title: "Read N Characters Given Read4 II",
            problem: "hard",
            company: ["Amazon", "Facebook", "Google"]
        },
        {
            index: 214,
            title: "Shortest Palindrome",
            problem: "hard",
            company: ["Google", "Microsoft"]
        },
        {
            index: 336,
            title: "Palindrome Pairs",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 466,
            title: "Count The Repetitions",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 564,
            title: "Find Closest Palindrome",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 591,
            title: "Tag Validator",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 727,
            title: "Minimum Window Subsequence",
            problem: "hard",
            company: ["Amazon", "Google"]
        },
        {
            index: 736,
            title: "Parse Lisp Expression",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 1585,
            title: "Check If String Is Transformable With Substring Sort Operations",
            problem: "hard",
            company: ["Google"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}


export default string