export interface MenuItem {
	title: string, 
	heading?: boolean,
	open?: boolean,
	path?: string,
	menuItems?: MenuItem[]
}
