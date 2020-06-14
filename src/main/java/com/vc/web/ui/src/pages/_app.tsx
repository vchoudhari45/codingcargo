import { AppProps } from 'next/app'
import { defaultLayout } from '../component/defaultLayout'
import '../css/index.css'
import "prismjs/themes/prism-okaidia.css"

const App = ({ Component, pageProps, router }: AppProps) => {
    return defaultLayout(<Component {...pageProps} />)
}
export default App