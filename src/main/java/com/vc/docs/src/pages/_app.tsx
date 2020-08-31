import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'
import ReactGA from 'react-ga'

ReactGA.initialize('UA-157613961-1', {titleCase: false, debug: false})
const App = (appProps: AppProps) => {
	return <DefaultLayout {...appProps.pageProps} />
}
export default App