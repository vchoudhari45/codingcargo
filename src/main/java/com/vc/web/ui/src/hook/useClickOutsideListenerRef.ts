import { useCallback, useEffect, useRef, Dispatch, SetStateAction } from 'react'

export const useClickOutsideListenerRef = (setIsOpen: Dispatch<SetStateAction<boolean>>) => {
    const ref = useRef(null)
    const escapeListener = useCallback((e: KeyboardEvent) => {
        if (e.key === 'Escape') {
            setIsOpen(false)
        }
    }, [])
    const clickListener = useCallback(
        (e: MouseEvent) => {
            if (!(ref.current! as any).contains(e.target)) {
                setIsOpen(false)
            }
        },
        [ref.current],
    )

    useEffect(() => {
        document.addEventListener('click', clickListener)
        document.addEventListener('keyup', escapeListener)
        return () => {
            document.removeEventListener('click', clickListener)
            document.removeEventListener('keyup', escapeListener)
        }
    }, [])
    return ref
}