import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'

const App = ({pageProps}: AppProps) => {
	return <DefaultLayout {...pageProps} />
}
export default App