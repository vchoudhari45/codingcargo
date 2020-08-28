import React, { Dispatch, MouseEvent, SetStateAction, useState } from "react"
import TrieItem from "../../model/TrieItem"
import { slug } from "../../util/url"

const TrieSearch = require('trie-search')

interface Props {
	setShowSearching: Dispatch<SetStateAction<boolean>>
	trieData: TrieItem[]
}

interface SearchState {
	showSearchPopup: boolean
	searchTerm: string
	hovered: number
	results: TrieItem[]
}

const searchBox: React.FC<Props> = ({setShowSearching, trieData}: Props) => {
	const [searchState, setSearchState] = useState<SearchState>({showSearchPopup: false, results: [], searchTerm: "", hovered: 0})

	const trie = new TrieSearch('title')
	trie.addAll(trieData)

	function handleOnChange(e: React.ChangeEvent<HTMLInputElement>) {
		if(e.target.value && e.target.value.length > 0) {
			setShowSearching(true)
			setSearchState({...searchState, hovered: 0, results: trie.get(e.target.value), showSearchPopup: true, searchTerm: e.target.value})
		}
		else {
			setShowSearching(false)
			setSearchState({...searchState, hovered: -1, searchTerm: "", showSearchPopup: false})
		}
	}

	function renderSearchResult(trieData: TrieItem[], searchTerm: string) : JSX.Element {
		const searchResultHtml = trieData.map((trieItem, index) => {
			return (
				<>
				  {
						<li role="option" id={"react-autowhatever-desktop-search--item-"+{index}} aria-selected="false" className={"react-autosuggest__suggestion "+(index == 0 ? "react-autosuggest__suggestion--first ": " ")+ (searchState.hovered == index ? "react-autosuggest__suggestion--highlighted ": "")} data-suggestion-index={index} onMouseEnter={() => setSearchState({...searchState, hovered: index})} onMouseLeave={() => setSearchState({...searchState, hovered: -1})}>
							<a className="jsx-2670105940" href={slug(trieItem.title)}>
									<span className="jsx-2670105940 suggestion__title">
										<span className="ais-Highlight">
											{
												trieItem.title.split(" ").map(s => {
													return (
														s.toLowerCase().startsWith(searchTerm.toLocaleLowerCase()) 
														? <> <mark className="ais-Highlight-highlighted">{s.substring(0, searchTerm.length)}</mark><span className="ais-Highlight-nonHighlighted">{s.substring(searchTerm.length) + " "}</span></>
														: <span className="ais-Highlight-nonHighlighted">{s + " "}</span>
													)
												})
											}
										</span>
									</span>
									<span className="jsx-2670105940 suggestion__content">

									</span>
							</a>
						</li>	
					}
				</>	
			)
		})
		return <ul role="listbox" className="react-autosuggest__suggestions-list">{searchResultHtml}</ul>
	}

	return (
		<label className="jsx-3672029349 input-container">
				<span className="jsx-3672029349 icon">
					<svg width="13" height="13" viewBox="0 0 13 13" xmlns="http://www.w3.org/2000/svg" fill="#000">
						<path d="M8.87 8.16l3.25 3.25-.7.71-3.26-3.25a5 5 0 1 1 .7-.7zM5 9a4 4 0 1 0 0-8 4 4 0 0 0 0 8z">
						</path>
					</svg>
				</span>
				<div role="combobox" aria-haspopup="listbox" aria-owns="react-autowhatever-desktop-search" aria-expanded="true" className={"react-autosuggest__container" + (searchState.showSearchPopup ? " react-autosuggest__container--open": "")}> 
					<input type="search" autoComplete="off" aria-autocomplete="list" aria-controls="react-autowhatever-desktop-search" className={"react-autosuggest__input" + (searchState.showSearchPopup ? " react-autosuggest__input--open": "")} placeholder="Search..." onChange={(e) => handleOnChange(e)}/>
					<div id="react-autowhatever-desktop-search" role="listbox" className={"react-autosuggest__suggestions-container" + (searchState.showSearchPopup ? " react-autosuggest__suggestions-container--open": "")}>
						{
							searchState.results && searchState.results.length > 0 ? renderSearchResult(searchState.results, searchState.searchTerm) : ""
						}
					</div>
				</div>
		</label>
	)
}

const memoSearchBox = React.memo(searchBox)
export default memoSearchBox