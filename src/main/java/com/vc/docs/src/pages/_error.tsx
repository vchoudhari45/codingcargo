function Error({ statusCode }) {}

Error.getInitialProps = ({ res, err }) => {
	const statusCode = res && res.statusCode ? res.statusCode : err && err.statusCode ? err.statusCode : 404
	const title = statusCode
  return { 
		content: "<h1>404</h1><p>Opps!!! Page you are looking for is not found</p>",
		selected: { title: title }
	}
}

export default Error