export const slug = (str: string) => {
	const slugged = str
	.toString()
	.toLowerCase()
	.trim()                     //remove spaces from start and end
	.replace(/\s+/g, "-")       //spaces to dashes
	.replace(/&/g, '-and-')     //ampersand to and
	.replace(/[^\w\-]+/g, "")   //remove non-words
	.replace(/\-\-+/g, '-')     //collapse multiple dashes
	.replace(/^-+/, '')         //trim starting dash
	.replace(/-+$/, '');        //trim ending dash

	return slugged
}

export const unslug = (str: string, seperator?: string) => {
	const unsluged = str
	.toString()
	.trim()
	.replace(/-/g, " ")       //dashes to spaces
	.split(' ')
	.map(word => word.charAt(0).toUpperCase() + word.slice(1))
	.join(seperator ? seperator : '')

	return unsluged
}

export const truncate = (str: string, n: number) => {
	return (str.length > n) ? str.substr(0, n) + '...' : str;
}