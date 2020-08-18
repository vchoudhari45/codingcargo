import Header from './layout/header'
import Sidebar from './layout/sidebar'
import MobileSidebar from './layout/mobileSidebar'

const DefaultLayout: React.FC = ({ children }) => {
	return (
			<>
				<Header />
					<div className="jsx-4169323174">
						<MobileSidebar />
						<div className="jsx-1998690184">
							<div className="jsx-1294800792 content">
								<Sidebar />
								{children}
							</div>
						</div>
					</div>
			</>
  )
}

export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>