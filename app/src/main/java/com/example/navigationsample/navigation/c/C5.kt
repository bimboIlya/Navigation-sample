package com.example.navigationsample.navigation.c

import com.example.navigationsample.R
import com.example.navigationsample.c.C5Router
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.navigation.MainRouter

class C5RouterImpl(
    private val mainRouter: MainRouter
) : C5Router {

    override fun popToC1() {
        mainRouter.popToRoot()
    }

    override fun popToC3() {
        mainRouter.popUpTo(C3Destination::class)
    }

    override fun pop() {
        mainRouter.pop()
    }
}

object C5Destination : FragmentDestinationById() {
    override val destinationId = R.id.c5Fragment
}