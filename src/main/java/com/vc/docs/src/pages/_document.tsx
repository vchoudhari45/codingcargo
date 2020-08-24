import Document, { Html, Head, Main, NextScript, DocumentContext } from 'next/document'

class CustomDocument extends Document {
    render() {
        return (
            <Html lang="en">
                <Head>
										<link rel="manifest" href="/manifest.json" />
										<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
										<link rel="preload" href="fonts/inter-cyrillic-ext.woff2" as="font" type="font/woff2" />
                    <meta name="theme-color" content="#FFFFFF"/>
                    <meta content="width=device-width, initial-scale=1" name="viewport" />
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