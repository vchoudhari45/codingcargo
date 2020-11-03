import { MenuItem } from "../../model/MenuItem"
import ReactHtmlParser from 'react-html-parser'
import { slug } from "../../util/url"
import { truncate } from "../../util/url"
import Prism from 'prismjs'
import React, { useEffect } from 'react'
import { BASE_URL, HOMEPAGE } from "../../data/menu"

interface Props {
	prev: MenuItem
	current: MenuItem
	next: MenuItem
	content: string
}

require('prismjs/components/prism-java')
const main: React.FC<Props> = ({prev, current, next, content}: Props) => {

	const shareUrl = current.title ? BASE_URL + slug(current.title) : null
	const title = current.title
	const contentArr = content ? content.split("\n") : ['','','','']

  useEffect(() => {
		Prism.highlightAll()
	})

	return (
		<>
			<div className="jsx-29590182 docs">
				
				<div id="reach-skip-nav" className="jsx-29590182 docs-content">
					{ contentArr.length < 4 ? ReactHtmlParser("<h1>Page not found</h1><p>We apologize for the inconvenience, but we can’t find the page you were looking for.</p><p><a href='https://www.codingcargo.com/' class='absolute'>Go to homepage</a></p>") : ReactHtmlParser(contentArr.slice(3).join("\n")) }
				</div>

				<div className="jsx-29590182 page-nav">
					{
						prev == null || title.toLowerCase() == HOMEPAGE.toLowerCase() ? <span className="jsx-113938279"></span> : 
						<a href={ BASE_URL + (prev.problem ? "problems/" + slug(prev.problem) + "/" + slug(prev.title) : slug(prev.title)) } className="jsx-4279592588 btn fw4 no-drag">
							<span className="jsx-113938279">
									<svg viewBox="0 0 24 24" width="24" height="24">
											<g fill="#0070f3">
												<path fill="#0070f3" d="M14,17.414l-4.707-4.707c-0.391-0.391-0.391-1.023,0-1.414L14,6.586L15.414,8l-4,4l4,4L14,17.414z" />
											</g>
									</svg>
							</span>
							<span className="pagination">{truncate(prev.title, 30)}</span>
							<span className="pagination-mobile">Prev</span>
						</a>
					}

					{
						next == null || title.toLowerCase() == HOMEPAGE.toLowerCase() ? <span className="jsx-29590182"></span> :
						<a href={ BASE_URL + (next.problem ? "problems/" + slug(next.problem) + "/" + slug(next.title) : slug(next.title)) } className="jsx-4279592588 btn fw4 no-drag">
							<span className="pagination">{truncate(next.title, 30)}</span>
							<span className="pagination-mobile">Next</span>
							<span className="jsx-3578282791">
									<svg width="24" height="24" viewBox="0 0 24 24">
											<g fill="#0070f3">
												<path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z" />
											</g>
									</svg>
							</span>
						</a>
					}
				</div>

				{/* {
					title && shareUrl && contentArr.length >= 5 && title.toLowerCase() != HOMEPAGE.toLowerCase() ? 
						<div className="jsx-29590182 page-nav">
							<span className="jsx-113938279"></span>
							<span className="jsx-3578282791">
								<FacebookShareButton url={shareUrl} title={title} quote={title} className="share-button">
									<FacebookIcon size={32} round />
								</FacebookShareButton>

								<TwitterShareButton url={shareUrl} title={title} className="share-button">
									<TwitterIcon size={32} round />
								</TwitterShareButton>

								<LinkedinShareButton url={shareUrl} title={title} className="share-button">
									<LinkedinIcon size={32} round />
								</LinkedinShareButton>

								<RedditShareButton url={shareUrl} title={title} className="share-button">
									<RedditIcon size={32} round />
								</RedditShareButton>

								<TumblrShareButton url={shareUrl} title={title} className="share-button">
									<TumblrIcon size={32} round />
								</TumblrShareButton>
							</span>
						</div>
						: ""
				} */}

				{
					current.title && contentArr.length >= 5 && title.toLowerCase() != HOMEPAGE.toLowerCase() ?
					<footer className="jsx-29590182">
					    <a href="https://github.com/vchoudhari45/codingcargo/issues" target="_blank" rel="noopener noreferrer" className="jsx-29590182">Have a question? Please create an issue here.</a>
					</footer>
					: ""
				}
			</div>
		</>
	)
}

export default main