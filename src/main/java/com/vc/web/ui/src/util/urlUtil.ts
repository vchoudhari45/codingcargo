import * as Constants from '../const'

export const generatePostUrl = (postTitle: string, full: boolean) => {
    const uri = _slug(postTitle)
    return full ? Constants.baseUrl + "/post/" + uri : "/post/" + uri
}

export const generateTagUrl = (category: string, tag: string, full: boolean) => {
    const uri = _slug(category) + "/" + _slug(tag)
    return full ? Constants.baseUrl + "/list/" + uri : "/list/" + uri
}

export const generateCategoryUrl = (category: string, full: boolean) => {
    const uri = "/list/" + _slug(category)
    return full ? Constants.baseUrl + "/" + uri : "/" + uri
}

export const urlVariableToValue = (urlVariable: string) => {
    return _unslug(urlVariable)
}


export const _slug = (str: string) => {
    const slugged = str
    .toString()
    .toLowerCase()
    .trim()                     //remove spaces from start and end
    .replace(/\s+/g, "-")       //spaces to dashes
    .replace(/&/g, '-and-')     //ampersand to and
    .replace(/[^\w\-]+/g, "")   //remove non-words
    .replace(/\-\-+/g, '-')     //collapse multiple dashes
    .replace(/^-+/, '')         //trim starting dash
    .replace(/-+$/, '');        //trim ending dash

    return slugged
}

export const _unslug = (str: string) => {
    const unsluged = str
    .toString()
    .trim()
    .replace(/-/g, " ")       //dashes to spaces
    .split(' ')
    .map(word => word.charAt(0).toUpperCase() + word.slice(1))
    .join(' ')

    return unsluged
}