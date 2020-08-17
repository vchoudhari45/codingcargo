import Header from './layout/header'

const DefaultLayout: React.FC = ({ children }) => {
	return (
			<>
				<Header />
					<div className="jsx-4169323174">
						<div className="jsx-249575869 shadow">
							<div className="jsx-1998690184">
								<div className="jsx-567598700 sidebar-search">
									<label className="jsx-3672029349 input-container">
											<span className="jsx-3672029349 icon">
												<svg width="13" height="13" viewBox="0 0 13 13" xmlns="http://www.w3.org/2000/svg" fill="#000">
													<path d="M8.87 8.16l3.25 3.25-.7.71-3.26-3.25a5 5 0 1 1 .7-.7zM5 9a4 4 0 1 0 0-8 4 4 0 0 0 0 8z">
													</path>
												</svg>
											</span>
											<div role="combobox" aria-haspopup="listbox" aria-owns="react-autowhatever-mobile-search" aria-expanded="false" className="react-autosuggest__container">
												<input type="search" value="" autoComplete="off" aria-autocomplete="list" aria-controls="react-autowhatever-mobile-search" className="react-autosuggest__input" placeholder="Search..."/>
												<div id="react-autowhatever-mobile-search" role="listbox" className="react-autosuggest__suggestions-container">
													<div className="jsx-1998690184">
													</div>
												</div>
											</div>
									</label>
								</div>

								<label className="jsx-567598700 dropdown-toggle">
									<input type="checkbox" id="dropdown-input" className="jsx-567598700"/>
									<div className="jsx-567598700 docs-select">
										<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
											<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" stroke-linecap="square" />
										</svg>
										Menu
									</div>
								</label>

								<div className="jsx-567598700 docs-dropdown">
									<div className="jsx-1998690184">
										<nav className="jsx-567598700">
											<div className="jsx-3875994729 heading">
												<h4 className="jsx-3875994729">Documentation</h4>
												<div className="jsx-3875994729">
													<div className="jsx-616696232 link level-2">
														<div className="jsx-3253412043 nav-link">
																<a className="jsx-3253412043" href="/docs/getting-started">Getting Started</a>
														</div>
													</div>

													<div className="jsx-2502836651 category level-2 open selected">
														<a className="jsx-2502836651 label">
															<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
																<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" stroke-linecap="square" />
															</svg>
															Basic Features
														</a>

														<div className="jsx-2502836651 posts">
															<div className="jsx-616696232 link level-3">
																<div className="jsx-3253412043 nav-link selected">
																	<a className="jsx-3253412043" href="/docs/basic-features/pages">Pages</a>
																</div>
															</div>
						
															<div className="jsx-616696232 link level-3">
																<div className="jsx-3253412043 nav-link">
																	<a className="jsx-3253412043" href="/docs/basic-features/data-fetching">Data fetching</a>
																</div>
															</div>
														</div>
													</div>

													<div className="jsx-2502836651 category level-2">
														<a className="jsx-2502836651 label">
															<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
																<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" stroke-linecap="square" />
															</svg>
															Routing
														</a>

														<div className="jsx-2502836651 posts">
															<div className="jsx-616696232 link level-3">
																<div className="jsx-3253412043 nav-link">
																	<a className="jsx-3253412043" href="/docs/routing/introduction">Introduction</a>
																</div>
															</div>

															<div className="jsx-616696232 link level-3">
																<div className="jsx-3253412043 nav-link">
																	<a className="jsx-3253412043" href="/docs/routing/dynamic-routes">Dynamic Routes</a>
																</div>
															</div>
															
														</div>
													</div>

													<div className="jsx-616696232 link level-2">
														<div className="jsx-3253412043 nav-link">
															<a className="jsx-3253412043" href="/docs/deployment">Deployment</a>
														</div>
													</div>
												</div>
										</div>
										</nav>
									</div>
								</div>
							</div>
						</div>
	
						<div className="jsx-1998690184">
							<div className="jsx-1294800792 content">
								<aside className="jsx-867702785 sidebar fixed">

									<div className="jsx-867702785 sidebar-search">
										<label className="jsx-3672029349 input-container">
											<span className="jsx-3672029349 icon">
												<svg width="13" height="13" viewBox="0 0 13 13" xmlns="http://www.w3.org/2000/svg" fill="#000">
													<path d="M8.87 8.16l3.25 3.25-.7.71-3.26-3.25a5 5 0 1 1 .7-.7zM5 9a4 4 0 1 0 0-8 4 4 0 0 0 0 8z" />
												</svg>
											</span>
											<div role="combobox" aria-haspopup="listbox" aria-owns="react-autowhatever-desktop-search" aria-expanded="false" className="react-autosuggest__container">
												<input type="search" value="" autoComplete="off" aria-autocomplete="list" aria-controls="react-autowhatever-desktop-search" className="react-autosuggest__input" placeholder="Search..."/>
												<div id="react-autowhatever-desktop-search" role="listbox" className="react-autosuggest__suggestions-container"></div>
											</div>
										</label>
									</div>

									<div className="jsx-867702785 sidebar-content">
										<div className="jsx-3875994729 heading">

											<h4 className="jsx-3875994729">Documentation</h4>
											<div className="jsx-3875994729">
												<div className="jsx-616696232 link level-2">
													<div className="jsx-3253412043 nav-link">
														<a className="jsx-3253412043" href="/docs/getting-started">Getting Started</a>
													</div>
												</div>

												<div className="jsx-2502836651 category level-2 open selected">
													<a className="jsx-2502836651 label">
														<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
															<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" stroke-linecap="square" />
														</svg>
														Basic Features
												</a>

												<div className="jsx-2502836651 posts">
													<div className="jsx-616696232 link level-3">
														<div className="jsx-3253412043 nav-link selected">
															<a className="jsx-3253412043" href="/docs/basic-features/pages">Pages</a>
														</div>
													</div>

													<div className="jsx-616696232 link level-3">
														<div className="jsx-3253412043 nav-link">
															<a className="jsx-3253412043" href="/docs/basic-features/data-fetching">Data fetching</a>
														</div>
													</div>
												</div>
											</div>

												<div className="jsx-2502836651 category level-2">
													<a className="jsx-2502836651 label">
														<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
															<path d="M1.4 8.56L4.67 5M1.4 1.23L4.66 4.7" stroke="#999" stroke-linecap="square" />
														</svg>
														Routing
												</a>

												<div className="jsx-2502836651 posts">
													<div className="jsx-616696232 link level-3">
														<div className="jsx-3253412043 nav-link">
															<a className="jsx-3253412043" href="/docs/routing/introduction">Introduction</a>
														</div>
													</div>
												</div>
											</div>

												<div className="jsx-616696232 link level-2">
													<div className="jsx-3253412043 nav-link">
														<a className="jsx-3253412043" href="/docs/deployment">Deployment</a>
													</div>
												</div>

												<div className="jsx-616696232 link level-2">
													<div className="jsx-3253412043 nav-link">
														<a className="jsx-3253412043" href="/docs/upgrading">Upgrade Guide</a>
													</div>
												</div>

												<div className="jsx-616696232 link level-2">
													<div className="jsx-3253412043 nav-link">
														<a className="jsx-3253412043" href="/docs/faq">FAQ</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</aside>
								{children}
							</div>
						</div>
					</div>
			</>
  )
}
export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>
