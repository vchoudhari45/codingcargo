import { AppProps } from 'next/app'
import { defaultLayout } from '../component/defaultLayout'
import { Router } from 'next/dist/client/router'
import '../css/index.css'

const App = ({ Component, pageProps, router }: AppProps) => {
    return defaultLayout(<Component {...pageProps} />)
}
export default App