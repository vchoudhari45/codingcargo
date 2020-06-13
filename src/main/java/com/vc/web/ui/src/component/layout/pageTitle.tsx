interface PageTitleProps {
    title: string
    description?: string
}
const PageTitle = ({ title, description }: PageTitleProps) => {
    return (
        <>
            <div className="flex justify-around items-center capitalize tracking-wide font-bold text-2xl md:text-3xl lg:text-4xl mt-6 mb-10 md:mt-8 md:mb-16">
                {title}
            </div>
            <div className="mb-10">{description || ""}</div>
        </>
    )
}

export default PageTitle