export interface MenuItem {
	title: string, 
	heading?: boolean,
	topic?: boolean,
	post?: boolean,
	problem?: string,
	index?: number,
	open?: boolean,
	menuItems?: MenuItem[],
	company?: string[]
}
