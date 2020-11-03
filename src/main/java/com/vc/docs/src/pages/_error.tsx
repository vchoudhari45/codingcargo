function Error({ statusCode }) {}

Error.getInitialProps = ({ res, err }) => {
	const statusCode = res && res.statusCode ? res.statusCode : err && err.statusCode ? err.statusCode : 404
	const headerMessage = statusCode == 404 ? "<h1>Page not found</h1>" : "<h1>Something went wrong</h1>"
	const contentMessage = statusCode == 404 ? "<p>We apologize for the inconvenience, but we can’t find the page you were looking for.</p><p><a href='https://www.codingcargo.com/' class='absolute'>Go to homepage</a></p>" : "<p>We apologize for the inconvenience, but we are unable to process your request at this time. Our engineers have been notified of this problem and will work to resolve it.</p><p><a href='https://www.codingcargo.com/' class='absolute'>Go to homepage</a></p>"
	return { 
		content: "[comment]: metadata=Coding Cargo Error page\n[comment]: keywords=Coding Cargo, Error Page\n[comment]: robots=noindex, nofollow\n"+headerMessage+"\n"+contentMessage,
		selected: { title: "Coding Cargo error page" }
	}
}

export default Error