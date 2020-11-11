const math = {
	title: "Math",
	topic: true,
	menuItems: [
		{
			index: 60,
			title: "Permutation Sequence",
			problem: "hard",
			company: ["Google"]
		},
		{
            index: 149,
            title: "Max Points on a Line",
            problem: "hard",
            company: ["Google", "Microsoft"]
        },
        {
            index: 233,
            title: "Number of Digit One",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 248,
            title: "Strobogrammatic Number III",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 273,
            title: "Integer to English Words",
            problem: "hard",
            company: ["Amazon", "Facebook", "Microsoft"]
        },
        {
            index: 335,
            title: "Self Crossing",
            problem: "hard",
            company: ["Amazon", "Google"]
        },
        {
            index: 420,
            title: "Strong Password Checker",
            problem: "hard",
            company: ["Amazon", "Google"]
        },
        {
            index: 440,
            title: "K th Smallest in Lexicographical Order",
            problem: "hard",
            company: ["Google"]
        },
        {
            index: 458,
            title: "Poor Pigs",
            problem: "hard"
        },
        {
            index: 479,
            title: "Largest Palindrome Product",
            problem: "hard",
            company: ["Amazon"]
        },
        {
            index: 517,
            title: "Super Washing Machines",
            problem: "hard",
            company: ["Amazon"]
        }
	].sort((a, b) => a.title.localeCompare(b.title))
}

export default math