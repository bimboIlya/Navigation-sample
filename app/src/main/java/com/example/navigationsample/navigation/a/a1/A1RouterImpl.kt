package com.example.navigationsample.navigation.a.a1

import com.example.navigationsample.a.a1.A1Router
import com.example.navigationsample.navigation.ImgChooserDestination
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.a.a2.A2Destination

class A1RouterImpl(
    private val mainRouter: MainRouter
) : A1Router {
    override fun openA2() {
        mainRouter.navigate(A2Destination)
    }

    override fun pickPic() {
        mainRouter.navigate(ImgChooserDestination)
    }
}