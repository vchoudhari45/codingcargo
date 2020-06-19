import Header from './layout/header'
import Footer from './layout/footer'
import { useRouter } from 'next/dist/client/router';
import { useState, useEffect } from 'react';

const DefaultLayout: React.FC = ({ children }) => {
    const router = useRouter();
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const handleStart = (url: string) => (url !== router.pathname) && setLoading(true);
        const handleComplete = (url: string) => (url !== router.pathname) && setLoading(false);

        router.events.on('routeChangeStart', handleStart)
        router.events.on('routeChangeComplete', handleComplete)
        router.events.on('routeChangeError', handleComplete)

        return () => {
            router.events.off('routeChangeStart', handleStart)
            router.events.off('routeChangeComplete', handleComplete)
            router.events.off('routeChangeError', handleComplete)
        }
    })

    return (
        <>
            <Header />
                <main>
                    <div className="mx-auto 
                                        pt-3    pr-6    pb-3    pl-8
                                        md:pt-3 md:pr-10 md:pb-3 md:pl-12
                                        lg:pt-3 lg:pr-20 lg:pb-3 lg:pl-20">
                        {
                            loading ? (<div className="loader ease-linear rounded-full border-8 border-t-8 border-gray-200 h-20 w-20"></div>) : children
                        }
                    </div>
                </main>
            <Footer />
        </>
    )
}
export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>
