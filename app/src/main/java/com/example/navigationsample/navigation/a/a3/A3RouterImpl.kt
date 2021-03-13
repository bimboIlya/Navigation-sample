package com.example.navigationsample.navigation.a.a3

import com.example.navigationsample.a.a3.A3Router
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.a.a4.A4Destination

class A3RouterImpl(
    private val mainRouter: MainRouter
) : A3Router {
    override fun openA4() = mainRouter.navigate(A4Destination)

    override fun pop() = mainRouter.pop()
}