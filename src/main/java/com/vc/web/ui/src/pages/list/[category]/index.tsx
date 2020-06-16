import { NextPage, GetStaticProps, NextPageContext } from "next"
import * as Constant from '../../../const'
import { getAllTagByCategoryName } from "../../../model/Tag"
import PageTitle from "../../../component/layout/pageTitle"
import { TagListWithCategory } from '../../../model/Tag'
import Metadata from "../../../component/layout/metadata"
import { generateCategoryUrl, urlVariableToValue } from "../../../util/urlUtil"
import TagListUI from "../../../component/tag/tagListUI"

interface Props {
    tagListWithCategory?: TagListWithCategory
    metaUrl: string
}
const CategoryPage: NextPage<Props> = ({ tagListWithCategory, metaUrl }) => {
    if (typeof tagListWithCategory != 'undefined') {
        return (
            <>
                <Metadata
                    title={tagListWithCategory.category.title + " - " + Constant.siteName}
                    description={tagListWithCategory.category.description}
                    keywords={tagListWithCategory.category.keywords}
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

interface CategoryPageContext extends NextPageContext {
    query: {
        category: string
    }
}
CategoryPage.getInitialProps = async ({ query }: CategoryPageContext) => {
    const categoryValue = urlVariableToValue(query.category)
    return {
        tagListWithCategory: await getAllTagByCategoryName(categoryValue, categoryValue),
        metaUrl: generateCategoryUrl(categoryValue, false)
    }
}
export default CategoryPage
