package com.example.navigationsample.navigation.a.a2

import com.example.navigationsample.a.a2.A2Router
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.a.a3.A3Destination
import com.example.navigationsample.navigation.a.a4.A4Destination

class A2RouterImpl(
    private val mainRouter: MainRouter
) : A2Router {
    override fun pop() = mainRouter.pop()

    override fun openA3() = mainRouter.navigate(A3Destination)

    override fun openA4() = mainRouter.navigate(A4Destination)
}