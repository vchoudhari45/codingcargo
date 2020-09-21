import { MenuItem } from "../model/MenuItem"
import array from "./array"
import backtracking from "./backtracking"
import binarySearch from "./binarySearch"
import dynamicProgramming from "./dynamicProgramming"
import greedyAlgorithm from "./greedyAlgorithm"
import linkedList from "./linkedList"
import priorityQueue from "./priorityQueue"
import stack from "./stack"
import string from "./string"
import math from "./math"
import tree from "./tree"
import trie from "./trie"
import graph from "./graph"
import slidingWindow from "./slidingWindow"
import map from "./map"

export const HOMEPAGE = "Getting Started"
export const BASE_URL = "https://www.codingcargo.com/"
export const SITE_NAME = "Coding Cargo"
export const TWITTER_HANDLE = "@coding_cargo"

const menuItems = []
const homePage = {
	title: HOMEPAGE,
	post: true
}

menuItems.push(homePage)
menuItems.push(array)
menuItems.push(backtracking)
menuItems.push(binarySearch)
menuItems.push(dynamicProgramming)
menuItems.push(graph)
menuItems.push(greedyAlgorithm)
menuItems.push(linkedList)
menuItems.push(map)
menuItems.push(math)
menuItems.push(priorityQueue)
menuItems.push(slidingWindow)
menuItems.push(stack)
menuItems.push(string)
menuItems.push(tree)
menuItems.push(trie)
export const MENU: MenuItem[] = [
	{
    title: "Problem Set",
		heading: true,
		menuItems: menuItems
	}
]