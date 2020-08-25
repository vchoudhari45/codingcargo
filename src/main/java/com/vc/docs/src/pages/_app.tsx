import { AppProps } from 'next/app'
import DefaultLayout from '../component/defaultLayout'
import '../css/index.css'
import { Router } from 'next/dist/client/router'
import NProgress from 'nprogress'

NProgress.configure({ showSpinner: false, easing: 'ease', speed: 1});
Router.events.on('routeChangeStart', () => NProgress.start()) 
Router.events.on('routeChangeComplete', () => NProgress.done())
Router.events.on('routeChangeError', () => NProgress.done())

const App = (appProps: AppProps) => {
	return <DefaultLayout {...appProps.pageProps} />
}
export default App