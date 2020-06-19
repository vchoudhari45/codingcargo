import Header from './layout/header'
import Footer from './layout/footer'

const DefaultLayout: React.FC = ({ children }) => {
    return (
        <>
            <Header />
                <main>
                    <div className="mx-auto 
                                        pt-3    pr-8    pb-3    pl-6
                                        md:pt-3 md:pr-20 md:pb-3 md:pl-16
                                        lg:pt-3 lg:pr-40 lg:pb-3 lg:pl-32">
                        {children}
                    </div>
                </main>
            <Footer />
        </>
    )
}
export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>
