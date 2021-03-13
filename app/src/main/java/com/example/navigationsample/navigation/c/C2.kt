package com.example.navigationsample.navigation.c

import com.example.navigationsample.R
import com.example.navigationsample.c.C2Router
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.navigation.MainRouter

class C2RouterImpl(
    private val mainRouter: MainRouter
) : C2Router {

    override fun openC3() {
        mainRouter.navigate(C3Destination("C3_id"))
    }

    override fun openC3Deeplink() {
        mainRouter.navigate(C3DestinationDeeplink("C3_deeplink"))
    }

    override fun pop() {
        mainRouter.pop()
    }
}

object C2Destination : FragmentDestinationById() {
    override val destinationId = R.id.c2Fragment
}