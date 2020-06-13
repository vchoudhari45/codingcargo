import _Tag from '../tag/_tag'
import { TagListWithCategory } from '../../model/Tag'

interface Props {
    tagListWithCategory: TagListWithCategory
}
const TagListUI = ({tagListWithCategory}: Props) => {
    const html = tagListWithCategory.tagList.map((tag, i) => {
        return <_Tag key={i} 
                     tag={tag} 
                     category={tagListWithCategory.category.title} />
    })
    return <>{html}</>
}

export default TagListUI 