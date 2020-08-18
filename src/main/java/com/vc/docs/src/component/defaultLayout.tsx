import Header from './layout/header'

const DefaultLayout: React.FC = ({ children }) => {
	return (
			<>
				<Header />
				<div className="jsx-4169323174">{children}</div>
			</>
  )
}

export const defaultLayout = (page: JSX.Element) => <DefaultLayout>{page}</DefaultLayout>