import { MenuItem } from "./MenuItem";

export default interface PageResponse {
	content: string,
	selected: MenuItem,
	metadata: string,
	keywords: string,
	robots: string
}