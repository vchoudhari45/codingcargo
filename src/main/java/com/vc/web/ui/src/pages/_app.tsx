import { AppProps } from 'next/app'
import { defaultLayout } from '../component/defaultLayout'
import { Router } from 'next/dist/client/router'
import NProgress from 'nprogress'
import '../css/index.css'

NProgress.configure({ showSpinner: false, speed: 400 });

Router.events.on('routeChangeStart', () => NProgress.start()) 
Router.events.on('routeChangeComplete', () => NProgress.done())
Router.events.on('routeChangeError', () => NProgress.done())

const App = ({ Component, pageProps, router }: AppProps) => {
    return defaultLayout(<Component {...pageProps} />)
}
export default App