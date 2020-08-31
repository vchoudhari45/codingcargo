function Error({ statusCode }) {}

Error.getInitialProps = ({ res, err }) => {
	const statusCode = res ? res.statusCode : err ? err.statusCode : 404
	const title = statusCode
  return { 
		content: statusCode == 404 ? "<h1>404</h1><p>Opps!!! Page you are looking for is not found</p>" : "<h1>"+statusCode+"</h1><p></p>",
		selected: { title: title }
	}
}

export default Error