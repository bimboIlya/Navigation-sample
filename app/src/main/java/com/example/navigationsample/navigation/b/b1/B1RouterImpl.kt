package com.example.navigationsample.navigation.b.b1

import com.example.navigationsample.b.b1.B1Router
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.about.AboutDestinationDeeplink
import com.example.navigationsample.navigation.b.b2.B2Destination

class B1RouterImpl(
    private val mainRouter: MainRouter
) : B1Router {

    override fun openB2(size: Int) {
        mainRouter.navigate(B2Destination(size))
    }

    override fun openAboutWithDeeplink() {
        mainRouter.navigate(AboutDestinationDeeplink)
    }
}