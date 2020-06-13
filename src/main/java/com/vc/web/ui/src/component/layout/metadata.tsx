import Head from 'next/head'
import * as Constants from '../../const'

interface MetadataProps {
    title: string, 
    description: string,
    keywords: string,
    url: string,
    robots: string
}
const Metadata = ({title, description, keywords, url, robots}: MetadataProps) => {
    const imgUrl = ""
    const imgWidth = ""
    const imgHeight = ""
    const twitterHandle = Constants.twitterHandle
    return (
        <Head>        
            <title>{title}</title>
            
            <meta key="charSet" charSet="UTF-9" />
            <meta key="viewport" name="viewport" content="initial-scale=1.0, width=device-width" />
            <meta name="description" content={description} />
            <meta name="keywords" content={keywords} />
            <meta name="robots" content={robots} />

            <meta key="og:locale" property="og:locale" content="en_US" />
            <meta key="og:type" property="og:type" content="website" />
            <meta key="og:title" property="og:title" content={Constants.siteName} />
            <meta key="og:description" property="og:description" content={description} />
            <meta key="og:site_name" property="og:site_name" content={Constants.siteName} />
            <meta key="og:url" property="og:url" content={url} />
            <meta key="og:image" property="og:image" content={imgUrl} />
            <meta key="og:image:secure_url" property="og:image:secure_url" content={imgUrl} />
            <meta key="og:image:width" property="og:image:width" content={imgWidth} />
            <meta key="og:image:height" property="og:image:height" content={imgHeight} />
            
            <meta key="twitter:title" name="twitter:title" content={title} />
            <meta key="twitter:description" name="twitter:description" content={description} />
            <meta key="twitter:card" name="twitter:card" content="summary" />
            <meta key="twitter:site" name="twitter:site" content={twitterHandle} /> 
            <meta key="twitter:image" name="twitter:image" content={imgUrl} />
        </Head>
    )
}
export default Metadata 