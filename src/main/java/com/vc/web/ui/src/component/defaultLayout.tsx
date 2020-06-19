import Header from './layout/header'
import Footer from './layout/footer'

const DefaultLayout: React.FC = ({ children }) => {
    return (
        <>
            <Header />
                <main>
                    <div className="mx-auto 
                                        pt-3    pr-6    pb-3    pl-8
                                        md:pt-3 md:pr-10 md:pb-3 md:pl-12
                                        lg:pt-3 lg:pr-20 lg:pb-3 lg:pl-20">
                        {children}
                    </div>
                </main>
            <Footer />
        </>
    )
}
export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>
