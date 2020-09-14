import { MenuItem } from "../model/MenuItem"
import array from "./array"
import backtracking from "./backtracking"
import binarySearch from "./binarySearch"
import dynamicProgramming from "./dynamicProgramming"
import greedyAlgorithm from "./greedyAlgorithm"
import linkedList from "./linkedList"
import priorityQueue from "./priorityQueue"
import stack from "./stack"
import hashmapMenu from "./hashmapMenu"
import string from "./string"
import math from "./math"
import slidingWindow from "./slidingWindow"

export const HOMEPAGE = "Getting Started"
export const BASEURL = "https://www.codingcargo.com/"
export const SITENAME = "Coding Cargo"
export const TWITTER_HANDLE = "@coding_cargo"

const menuItems = []
const homePage = {
	title: HOMEPAGE,
	post: true
}

//menuItems.push(homePage)
menuItems.push(array)
menuItems.push(backtracking)
menuItems.push(binarySearch)
menuItems.push(dynamicProgramming)
menuItems.push(greedyAlgorithm)
menuItems.push(hashmapMenu)
menuItems.push(linkedList)
menuItems.push(math)
menuItems.push(priorityQueue)
menuItems.push(slidingWindow)
menuItems.push(stack)
menuItems.push(string)
export const MENU: MenuItem[] = [
	{
    title: "Problem Set",
		heading: true,
		menuItems: menuItems
	}
]