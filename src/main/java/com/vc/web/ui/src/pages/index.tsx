import { NextPage, GetStaticProps } from 'next'
import * as Constant from '../const'
import { TagListWithCategory } from '../model/Tag'
import Metadata from '../component/layout/metadata'
import TagListUI from '../component/tag/tagListUI'
import PageTitle from '../component/layout/pageTitle'
import { getAllTagByCategoryName } from '../model/Tag'

interface Props {
    tagListWithCategory?: TagListWithCategory
    metaUrl: string
}
const Home: NextPage<Props> = ({ tagListWithCategory, metaUrl }) => {
    const homePageDescription = Constant.siteName + " is a website for technical interview preparation. It has a large collection of Data Structures And Algorithms Problems from coding websites like leetcode with simple and easy to understand solutions. This website will help anyone who wants to  improve on their coding skills and crack interviews of top tech companies like Amazon, Facebook, Google & Microsoft"

    if (typeof tagListWithCategory != 'undefined') {
        return (
            <>
                <Metadata
                    title={Constant.siteName + " - " + Constant.siteTagLine}
                    description={homePageDescription}
                    keywords="Technical Interview Preparation, Data Structures And Algorithms, Leetcode"
                    url={metaUrl}
                    robots="index, nofollow" />

                <PageTitle
                    title={tagListWithCategory.category.title}
                    description={tagListWithCategory.category.description} />

                <TagListUI tagListWithCategory={tagListWithCategory} />
            </>
        )
    }
    else return (<div>{Constant.errorMessage}</div>)
}

export const getStaticProps: GetStaticProps = async () => {
    return {
        props: {
            tagListWithCategory: await getAllTagByCategoryName("Data Structures And Algorithms", "Data Structures And Algorithms"),
            metaUrl: Constant.baseUrl
        }
    }
}
export default Home 