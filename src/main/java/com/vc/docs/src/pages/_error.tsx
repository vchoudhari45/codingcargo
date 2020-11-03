function Error({ statusCode }) {}

Error.getInitialProps = ({ res, err }) => {
	const headerMessage = "<h1>Page not found</h1>"
	const contentMessage = "<p>We apologize for the inconvenience, but we can’t find the page you were looking for.</p><p><a href='https://www.codingcargo.com/' class='absolute'>Go to homepage</a></p>"
	return { 
		content: "[comment]: metadata=Coding Cargo Error page\n[comment]: keywords=Coding Cargo, Error Page\n[comment]: robots=noindex, nofollow\n"+headerMessage+"\n"+contentMessage,
		selected: { title: "Coding Cargo error page" }
	}
}

export default Error