import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'
import ReactGA from 'react-ga'
import Head from 'next/head'
import { HOMEPAGE } from '../data/menu'

ReactGA.initialize('UA-157613961-1', {titleCase: false, debug: false})
const App = (appProps: AppProps) => {
	const title = appProps.pageProps.selected ? appProps.pageProps.selected.title : HOMEPAGE
	return (
		<>
			<Head><title>{title}</title></Head>
			<DefaultLayout {...appProps.pageProps} />
		</>	
	)
}
export default App