import React, { Dispatch, SetStateAction, useEffect, useState } from "react"

interface Props {
	setShowSearching: Dispatch<SetStateAction<boolean>>
}

interface SearchState {
	showSearchPopup: boolean
}

const searchBox: React.FC<Props> = ({setShowSearching}: Props) => {
	const [searchState, setSearchState] = useState<SearchState>({showSearchPopup: false})

	useEffect(() => {
		//Generate trie
	}, [])

	function handleOnChange(e: React.ChangeEvent<HTMLInputElement>) {
		if(e.target.value && e.target.value.length > 0) {
			setShowSearching(true)
			setSearchState({...searchState, showSearchPopup: true})
		}
		else {
			setShowSearching(false)
			setSearchState({...searchState, showSearchPopup: false})
		}
		console.log(e.target.value)
		//Update Value in searchBox State
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
					<ul role="listbox" className="react-autosuggest__suggestions-list">
						<li role="option" id="react-autowhatever-desktop-search--item-0" aria-selected="false" className="react-autosuggest__suggestion react-autosuggest__suggestion--first" data-suggestion-index="0">
								<a className="jsx-2670105940" href="/docs/faq">
										<span className="jsx-2670105940 suggestion__title">
											<span className="ais-Highlight">
												<span className="ais-Highlight-nonHighlighted">Two </span>
													<mark className="ais-Highlight-highlighted">Sum</mark>
												<span className="ais-Highlight-nonHighlighted"> Problem</span>
											</span>
										</span>
										<span className="jsx-2670105940 suggestion__content">
										</span>
								</a>
							</li>
							<li role="option" id="react-autowhatever-desktop-search--item-1" aria-selected="false" className="react-autosuggest__suggestion react-autosuggest__suggestion--highlighted" data-suggestion-index="1">
								<a className="jsx-2670105940" href="/docs/basic-features/supported-browsers-features">
									<span className="jsx-2670105940 suggestion__title">
										<span className="ais-Highlight">
											<span className="ais-Highlight-nonHighlighted">Three </span>
												<mark className="ais-Highlight-highlighted">Sum</mark>
											<span className="ais-Highlight-nonHighlighted"> Problem</span>
										</span>
									</span>
									<span className="jsx-2670105940 suggestion__content">
									</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
		</label>
	)
}

const memoSearchBox = React.memo(searchBox)
export default memoSearchBox