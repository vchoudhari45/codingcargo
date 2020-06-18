import { useState } from 'react'
import Link from 'next/link'
import { useClickOutsideListenerRef } from '../../hook/useClickOutsideListenerRef'
import { generateTagUrl } from '../../util/urlUtil'

const Header: React.FC = props => {
    const [isOpen, setIsOpen] = useState(false)
    const ref = useClickOutsideListenerRef(setIsOpen)

    const menuLinkArray = [
        {
            "category": "Home",
            "tagValue": "Home",
            "title": "Home"
        },
        {
            "category": "Data Structures And Algorithms",
            "tagValue": "Amazon",
            "title": "Asked in Amazon"
        },
        {
            "category": "Data Structures And Algorithms",
            "tagValue": "Facebook",
            "title": "Asked in Facebook"
        },
        {
            "category": "Data Structures And Algorithms",
            "tagValue": "Google",
            "title": "Asked in Google"
        },
        {
            "category": "Data Structures And Algorithms",
            "tagValue": "Microsoft",
            "title": "Asked in Microsoft"
        }
    ]

    const menuCss = "md:tracking-tight text-sm md:text-base rounded-md text-gray-500 hover:bg-gray-800 hover:text-white md:hover:bg-gray-900 mt-1 px-2 py-2 md:mt-0 md:px-0 md:py-0 block md:inline-block md:ml-3 md:mr-3"
    const menuHtml = menuLinkArray.map((link, i) => {
        return link.category == "Home" 
        ? <Link key={i} href="/"><a className={menuCss}>{link.title}</a></Link>
        : <Link key={i} href="/list/[category]/[tag]/" as={generateTagUrl(link.category, link.tagValue, false)} prefetch={false}><a className={menuCss}>{link.title}</a></Link>
    })

    return (
        <div>
            <div ref={ref} className="pt-3    pr-3    pb-3    pl-3
                                      md:pt-3 md:pr-10 md:pb-3 md:pl-10
                                      lg:pt-3 lg:pr-20 lg:pb-3 lg:pl-20 
                                      md:flex md:justify-around md:items-center bg-gray-900">
                <div className="flex justify-end md:hidden">
                    <div id="logo" className="h-6 w-6 hidden">
                        <Link href="/">
                            <a className="no-underline hover:text-white">
                                <svg className="fill-current text-gray-500 hover:text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                                    <path d="M5.719 14.75a.997.997 0 01-.664-.252L-.005 10l5.341-4.748a1 1 0 011.328 1.495L3.005 10l3.378 3.002a1 1 0 01-.664 1.748zm8.945-.002L20.005 10l-5.06-4.498a.999.999 0 10-1.328 1.495L16.995 10l-3.659 3.252a1 1 0 001.328 1.496zm-4.678 1.417l2-12a1 1 0 10-1.972-.329l-2 12a1 1 0 101.972.329z" />
                                </svg>
                            </a>
                        </Link>
                    </div>

                    <div id="menu-ham" className="h-6 w-6 cursor-pointer">
                        <svg onClick={() => { setIsOpen(!isOpen) }} className="fill-current text-gray-500 hover:text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                            {
                                isOpen
                                    ? <path d="M14.348 14.849a1.2 1.2 0 01-1.697 0L10 11.819l-2.651 3.029a1.2 1.2 0 11-1.697-1.697l2.758-3.15-2.759-3.152a1.2 1.2 0 111.697-1.697L10 8.183l2.651-3.031a1.2 1.2 0 111.697 1.697l-2.758 3.152 2.758 3.15a1.2 1.2 0 010 1.698z" />
                                    : <path d="M16.4 9H3.6c-.552 0-.6.447-.6 1 0 .553.048 1 .6 1h12.8c.552 0 .6-.447.6-1 0-.553-.048-1-.6-1zm0 4H3.6c-.552 0-.6.447-.6 1 0 .553.048 1 .6 1h12.8c.552 0 .6-.447.6-1 0-.553-.048-1-.6-1zM3.6 7h12.8c.552 0 .6-.447.6-1 0-.553-.048-1-.6-1H3.6c-.552 0-.6.447-.6 1 0 .553.048 1 .6 1z" />
                            }
                        </svg>
                    </div>
                </div>
                <div id="menu" className={(isOpen ? "block" : "hidden") + " md:inline-block"}>
                    {menuHtml}
                </div>
            </div>
        </div>
    )
}

export default Header