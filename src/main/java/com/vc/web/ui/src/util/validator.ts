import { isNull, isUndefined } from "util"

export const isUndefinedOrNull = (strVariable?: string) => {
    return isUndefined(strVariable) || isNull(strVariable) || strVariable.trim() == ''
}

export const isInteger = (strVariable?: string) => {
    try { 
        const intVariable = Number.parseInt(strVariable as string)
        return !isNaN(intVariable)
    }
    catch(error) {
        return false
    }
}