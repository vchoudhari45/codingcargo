import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'
import Head from 'next/head'
import { HOMEPAGE } from '../data/menu'
import CookieConsent from 'react-cookie-consent'

const App = (appProps: AppProps) => {
	const title = appProps.pageProps.selected ? appProps.pageProps.selected.title : HOMEPAGE
	return (
		<>
			<Head><title>{title}</title></Head>
			<DefaultLayout {...appProps.pageProps} />
			<CookieConsent
				location="bottom"
				acceptOnScroll={true}
				acceptOnScrollPercentage={25}
				style={{
					background: "#252e39",
					color: "#cbcdd0"
				}}
				buttonStyle={{ fontWeight: "bold", background: "#237AFC", padding: "10px 40px", borderRadius: "7px", color: "white" }}
				buttonText="Got it!"
				cookieName="__consent_cookie">
					We serve cookies on this site to analyze traffic, remember your preferences, and optimize your experience.
					<a className="cookie-learn-more" aria-label="Learn more about cookies" href="https://www.cookiesandyou.com" target="_blank"> Learn more</a>
      </CookieConsent>
		</>	
	)
}
export default App