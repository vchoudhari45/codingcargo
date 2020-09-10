import Document, { Html, Head, Main, NextScript, DocumentContext } from 'next/document'
import { BASEURL, HOMEPAGE, SITENAME, TWITTER_HANDLE } from '../data/menu'
import { slug } from '../util/url'

class CustomDocument extends Document {
	render() {
		const pageProps = this.props.__NEXT_DATA__.props.pageProps

		//extract fields from pageProps
		const title = pageProps.selected ? pageProps.selected.title : HOMEPAGE
		const contentArr = pageProps.content ? pageProps.content.split("\n") : ['','','']
		const metadata = contentArr[0] ? contentArr[0].replace("[comment]: metadata=", "") : ""
		const keywords = contentArr[1] ? contentArr[1].replace("[comment]: keywords=", "") : ""
		const robots = contentArr[2] ? contentArr[2].replace("[comment]: robots=", "") : ""
		const url = BASEURL + slug(title)

		//imgUrl 
		const imgUrl = BASEURL + "social-share-image.png"
		const imgWidth = "180"
		const imgHeight = "180"

		return (
			<Html lang="en">
				<Head>
				  <link href="data:image/x-icon;base64,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
nERDtQAAAABJRU5ErkJggg==" rel="icon" type="image/x-icon" />
					<link rel="manifest" href={BASEURL + "manifest.json"} />
					<link rel="preconnect" href="https://www.google-analytics.com"></link>
					<link rel="apple-touch-icon" href={BASEURL + "apple-touch-icon.png"} />

					<meta name="theme-color" content="#FFFFFF"/>
					<meta name="viewport" content="width=device-width, initial-scale=1" />
					<meta name="description" content={metadata} />
					<meta name="keywords" content={keywords} />
					<meta name="robots" content={robots} />

					<meta key="og:locale" property="og:locale" content="en_US" />
					<meta key="og:type" property="og:type" content="website" />
					<meta key="og:title" property="og:title" content={SITENAME} />
					<meta key="og:description" property="og:description" content={metadata} />
					<meta key="og:site_name" property="og:site_name" content={SITENAME} />
					<meta key="og:url" property="og:url" content={url} />
					<meta key="og:image" property="og:image" content={imgUrl} />
					<meta key="og:image:secure_url" property="og:image:secure_url" content={imgUrl} />
					<meta key="og:image:width" property="og:image:width" content={imgWidth} />
					<meta key="og:image:height" property="og:image:height" content={imgHeight} />

					<meta key="twitter:title" name="twitter:title" content={title} />
					<meta key="twitter:description" name="twitter:description" content={metadata} />
					<meta key="twitter:card" name="twitter:card" content="summary" />
					<meta key="twitter:site" name="twitter:site" content={TWITTER_HANDLE} /> 
					<meta key="twitter:image" name="twitter:image" content={imgUrl} />
				</Head>
				<body className="text-sm md:text-base">
						<Main />
						<NextScript />
				</body>
			</Html>
		)
	}
}

CustomDocument.getInitialProps = async(context: DocumentContext) => {
  const initialProps = await Document.getInitialProps(context)
  return { ...initialProps }
}

export default CustomDocument