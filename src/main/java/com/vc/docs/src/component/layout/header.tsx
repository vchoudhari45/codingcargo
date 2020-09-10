import React from "react"
import { BASEURL, HOMEPAGE } from "../../data/menu"

const Header: React.FC = () => {
	return(	
		<header className="jsx-1673863491">
			<div className="jsx-3256009215">
				<a tabIndex={0} href="#reach-skip-nav" data-reach-skip-link="true">Skip to content</a>
				<nav className="jsx-2492631047 f-reset">
					<div className="jsx-2492631047 mobile-top">
						<a title={HOMEPAGE} className="jsx-2492631047 mobile-logo" href={BASEURL}>
							<svg role="img" aria-label="Coding Cargo logo" width="190" height="40">
								<title>Coding Cargo logo</title>
  				 		  <desc>Coding Cargo logo</desc>
								<image width="190" height="40" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAeAAAABTCAMAAABwIyTIAAAABGdBTUEAALGPC/xhBQAAACBjSFJN AAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAC91BMVEUAAAAVFSoaHi8aHy0a HywaHywZIC0aIC0aIC0aIS0aIC0bIC0aIC0ZIC0bIC0bIC0bICoaIS4aIC0aIS4aHy0aHy0YHy0a GiYaIC0ZHi0cIjAYICwkJCQaIC4bIC4aIC0aIS0aICwaIC0cHCsbHi4ZHy0aISwaIS4AAEAbIC0Z Hy4aGjMbIS0aICwbHywcIC4aHy0AAFUdHTEaIS4aICwZIC4ZISwXHy4gICAbHy4aISwbHy4VKioZ HywaISwZIS0aIC0ZICwZIC0aHywcHDkbIC4AAAAZIC4bIC0aIC0ZIS0SJCQaIC0fHykbIS0eHi0a IC0UJycbIC0ZHy4aIi8YIisaIC0aIC0aICwXIy4aHy0bHy0ZIC4aIC0bHy4XFy4aIC0aIC0ZIS4a IC0ZHy4YJDEaIC0aIC0aIS4zMzMbJC4AQEAaIS4bIS0cISwaHy0ZHywaIi0bHywaHy0aHiscIS8W ISwAAAAbIiwaIS0ZISwaIC0bHi4cIysZHy0aICwaIC0aIS0bGygbISwaIC0ZIC4ZIS0dHSwiIjMZ ISkXHi0VICoaIC0bISwYIDAaIioaHywgIDAaIC0bHy0cICwaIC0aJjMaIC0aICwaISwaIC4aHy4a IC0ZISwbIC0aICwaIC0YIC0bIC0aIS4cIi0cHC8bIS4YISoYHi8aICwaHy8aIC0aIC0aIC0ZIiwb ISsaIC0bIS4aHywaIC4ZIC0aIC0aIC0qKioYHisbIC0aIC0aIC4aIC4aIC4aIC0aIS0aIC0aIC0a IC0aIS0aHy0aHywZHy0bIC4aIC0aICwaIS4aHy0bHysaIS0ZHywbICwaIC0cHCsaIC0bIC0aIC0a IC0aIC0aIC0ZIS4aIC0aIC0XIy4aICwZHywaICwZIC0aIC0aIC0aHywZICwZHy0aIS4aIC0bIC4b IS4aIC0aIC4ZHy0SJDcaIC0aHy0ZIC8aIC0bHy0aIywaIS0bISwaISwbGy4aIC4aHi0aIS4ZICwa IC3///+9oO4PAAAA+3RSTlMADDxsm8PS4fD77N3Ov49gME6d69uSSRSxMyVAB884d6TP7RJUW5XE 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 OjQxOjU3KzAzOjAwjne8fQAAAABJRU5ErkJggg=="/>
							</svg>
						</a>
						{/* <div className="jsx-2492631047 learn">
							<a href="/learn/basics/create-nextjs-app?utm_source=next-site&amp;utm_medium=homepage-cta&amp;utm_campaign=next-website" className="jsx-4279592588 btn fw4 no-drag">Learn</a>
						</div> */}
					</div>

					<div className="jsx-2492631047 links">
						<a className="jsx-2492631047 logo" href={BASEURL}>
							<svg role="img" aria-label="Coding Cargo logo" width="190" height="50">
							  <title>Coding Cargo logo</title>
  				 		  <desc>Coding Cargo logo</desc>
								<image width="190" height="50" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAeAAAABTCAMAAABwIyTIAAAABGdBTUEAALGPC/xhBQAAACBjSFJN AAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAC91BMVEUAAAAVFSoaHi8aHy0a HywaHywZIC0aIC0aIC0aIS0aIC0bIC0aIC0ZIC0bIC0bIC0bICoaIS4aIC0aIS4aHy0aHy0YHy0a GiYaIC0ZHi0cIjAYICwkJCQaIC4bIC4aIC0aIS0aICwaIC0cHCsbHi4ZHy0aISwaIS4AAEAbIC0Z Hy4aGjMbIS0aICwbHywcIC4aHy0AAFUdHTEaIS4aICwZIC4ZISwXHy4gICAbHy4aISwbHy4VKioZ HywaISwZIS0aIC0ZICwZIC0aHywcHDkbIC4AAAAZIC4bIC0aIC0ZIS0SJCQaIC0fHykbIS0eHi0a IC0UJycbIC0ZHy4aIi8YIisaIC0aIC0aICwXIy4aHy0bHy0ZIC4aIC0bHy4XFy4aIC0aIC0ZIS4a IC0ZHy4YJDEaIC0aIC0aIS4zMzMbJC4AQEAaIS4bIS0cISwaHy0ZHywaIi0bHywaHy0aHiscIS8W ISwAAAAbIiwaIS0ZISwaIC0bHi4cIysZHy0aICwaIC0aIS0bGygbISwaIC0ZIC4ZIS0dHSwiIjMZ ISkXHi0VICoaIC0bISwYIDAaIioaHywgIDAaIC0bHy0cICwaIC0aJjMaIC0aICwaISwaIC4aHy4a IC0ZISwbIC0aICwaIC0YIC0bIC0aIS4cIi0cHC8bIS4YISoYHi8aICwaHy8aIC0aIC0aIC0ZIiwb ISsaIC0bIS4aHywaIC4ZIC0aIC0aIC0qKioYHisbIC0aIC0aIC4aIC4aIC4aIC0aIS0aIC0aIC0a IC0aIS0aHy0aHywZHy0bIC4aIC0aICwaIS4aHy0bHysaIS0ZHywbICwaIC0cHCsaIC0bIC0aIC0a IC0aIC0aIC0ZIS4aIC0aIC0XIy4aICwZHywaICwZIC0aIC0aIC0aHywZICwZHy0aIS4aIC0bIC4b IS4aIC0aIC4ZHy0SJDcaIC0aHy0ZIC8aIC0bHy0aIywaIS0bISwaISwbGy4aIC4aHi0aIS4ZICwa IC3///+9oO4PAAAA+3RSTlMADDxsm8PS4fD77N3Ov49gME6d69uSSRSxMyVAB884d6TP7RJUW5XE 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 OjQxOjU3KzAzOjAwjne8fQAAAABJRU5ErkJggg=="/>
							</svg>
						</a>
						<a title="All Problemset" className="jsx-2492631047 mute" href={BASEURL + "all-problem-set"}>All</a>
						<a title="Amazon Problemset" className="jsx-2492631047 mute" href={BASEURL + "amazon-problem-set"}>Amazon</a>
						<a title="Facebook Problemset" className="jsx-2492631047 mute" href={BASEURL + "facebook-problem-set"}>Facebook</a>
						<a title="Google Problemset" className="jsx-2492631047 mute" href={BASEURL + "google-problem-set"}>Google</a>
						<a title="Microsoft Problemset" className="jsx-2492631047 mute" href={BASEURL + "microsoft-problem-set"}>Microsoft</a>
						{/* <div className="jsx-2492631047 learn">
							<a href="/learn/basics/create-nextjs-app?utm_source=next-site&amp;utm_medium=homepage-cta&amp;utm_campaign=next-website" className="jsx-4279592588 btn fw4 no-drag">Learn</a>
						</div> */}
					</div>
				</nav>
			</div>
		</header>
  )
}

const memoHeader = React.memo(Header)
export default memoHeader
