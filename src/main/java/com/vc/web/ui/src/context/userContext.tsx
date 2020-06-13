import React, { useState, Component, createContext, PropsWithChildren, Children, useEffect } from 'react'
import { firebaseAuth } from '../firebase/clientApp'

export type User = {
    displayName: String,
    email: String
}
type UserContextType = {
    user: User | null
    loadingUser: boolean
}

export const UserContext = React.createContext<UserContextType | null>(null)
export const UserProvider: React.FC = ({ children }) => {
    const [user, setUser] = useState<User | null>(null)
    const [loadingUser, setLoadingUser] = useState(true)

    useEffect(() => {
        const unsubscriber = firebaseAuth.onAuthStateChanged(async fireBaseUser => {
            try {
                if (fireBaseUser) {
                    setUser({
                        displayName: fireBaseUser.displayName ?? '',
                        email: fireBaseUser.email ?? ''
                    })
                }
                else {
                    setUser(null)
                }
            } catch (error) {
                console.log(error)
            } finally {
                setLoadingUser(false)
            }
        })

        //Only called when react unmounts the component 
        return () => unsubscriber()
    }, [])

    return (
        <UserContext.Provider value={{ user, loadingUser }}>
            {children}
        </UserContext.Provider>
    )
}