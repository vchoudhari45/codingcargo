import Link from "next/link"
import * as Constants from '../../const'

export interface PaginationProps {
    baseUrl: string,
    totalElements: number,
    currentPage: number
}
const Pagination = ({ baseUrl, totalElements, currentPage }: PaginationProps) => {
    const html = generatePagination(totalElements, currentPage, baseUrl, 2)
    const mdHtml = generatePagination(totalElements, currentPage, baseUrl, 7)
    const lgHtml = generatePagination(totalElements, currentPage, baseUrl, 10)
    return (    
        <div className="flex justify-center items-center mt-20">
            <div className="block md:hidden lg:hidden">{html}</div>
            <div className="hidden md:block lg:hidden">{mdHtml}</div>
            <div className="hidden md:hidden lg:block">{lgHtml}</div>
        </div>
    )
}

const generatePagination = (totalElements:number, currentPage: number, baseUrl: string, range: number): JSX.Element[] => {
    let totalPages = Math.floor(totalElements / Constants.pageSize)
    totalPages = (totalElements % Constants.pageSize) != 0 ? totalPages + 1 : totalPages

    let from = Math.max(0, currentPage - range)
    let to = Math.min(currentPage + range, totalPages)

    let html: JSX.Element[] = []

    if(totalPages == 1) return html

    if(currentPage > 1) {
        html.push(
            <Link key="prev" href="/list/[category]/[tag]/[page]/" as={baseUrl + "/" + (currentPage == 2 ? "" : currentPage - 1)} prefetch={false}>
                <a className="px-4 py-3">Prev</a>
            </Link>
        )
    }
    for (let i = from; i < to; i++) {
        if (i == 0) {
            html.push(
                <Link key={i} href="/list/[category]/[tag]/[page]/" as={baseUrl} prefetch={false}>
                    <a className={i == currentPage || i  + 1 == currentPage ? "px-4 py-3 rounded-md border-solid border border-gray-400 bg-gray-200" : "px-4 py-3"}>1</a>
                </Link>
            )
        }
        else {
            html.push(
                <Link key={i} href="/list/[category]/[tag]/[page]/" as={baseUrl + "/"+(i + 1)} prefetch={false}>
                    <a className={i + 1 == currentPage ? "px-4 py-3 rounded-md border-solid border border-gray-400 bg-gray-200" : "px-4 py-3"}>{i + 1}</a>
                </Link>
            )
        }
    }
    if(currentPage < to) {
        html.push(
            <Link key="next" href="/list/[category]/[tag]/[page]/" as={baseUrl + "/" + (currentPage == 0 ? currentPage + 2 : currentPage + 1)}> prefetch={false}
                <a className="px-4 py-3">Next</a>
            </Link>
        )
    }
    return html
}

export default Pagination 