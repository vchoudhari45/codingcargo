import Head from 'next/head'

export default function Home() {
  return (
    <div className="container">
      <Head>
        <title>Create Next App</title>
      </Head>

      <div className="jsx-29590182 docs">
        <div className="jsx-29590182 docs-content">
					<h1>Getting Started</h1>
					<p>Welcome to CodingCargo.com, and add your .md content here from github so that you can have an option to edit the .md file and that it</p>	
        </div>

				<div className="jsx-29590182 page-nav">
					<a href="/docs/getting-started" className="jsx-4279592588 btn fw4 no-drag">
							<span className="jsx-113938279">
									<svg viewBox="0 0 24 24" width="24" height="24">
											<g fill="#0070f3">
													<path fill="#0070f3" d="M14,17.414l-4.707-4.707c-0.391-0.391-0.391-1.023,0-1.414L14,6.586L15.414,8l-4,4l4,4L14,17.414z" />
											</g>
									</svg>
							</span>Getting Started
					</a>

					<a href="/docs/basic-features/data-fetching" className="jsx-4279592588 btn fw4 no-drag">
							Data fetching
							<span className="jsx-3578282791">
									<svg width="24" height="24" viewBox="0 0 24 24">
											<g fill="#0070f3">
													<path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z" />
											</g>
									</svg>
							</span>
					</a>
			</div>

			<footer className="jsx-29590182">
					<a href="https://github.com/vercel/next.js/edit/canary/docs/basic-features/pages.md" target="_blank" rel="noopener noreferrer" className="jsx-29590182">Edit this page on GitHub</a>
			</footer>
    </div>
	</div>
  )
}
