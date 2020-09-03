export interface MenuItem {
	title: string, 
	heading?: boolean,
	topic?: boolean,
	post?: boolean,
	problem?: string,
	open?: boolean,
	menuItems?: MenuItem[]
}
