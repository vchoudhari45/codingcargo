import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'

const App = (appProps: AppProps) => {
	return <DefaultLayout {...appProps.pageProps} />
}
export default App