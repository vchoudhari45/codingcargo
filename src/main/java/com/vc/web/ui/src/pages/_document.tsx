import Document, { Html, Head, Main, NextScript, DocumentContext } from 'next/document'

class CustomDocument extends Document {
    render() {
        return (
            <Html lang="en">
                <Head>
                    <link rel="manifest" href="/manifest.json" />
                    <link rel="apple-touch-icon" href="/apple-touch-icon.png" />
                    <meta name="theme-color" content="#FFFFFF"/>
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