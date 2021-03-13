package com.example.navigationsample.navigation.a.a4

import com.example.navigationsample.a.a4.A4Router
import com.example.navigationsample.navigation.MainRouter

class A4RouterImpl(
    private val mainRouter: MainRouter
) : A4Router {
    override fun pop() = mainRouter.pop()

    override fun popToA1() = mainRouter.popToRoot()
}