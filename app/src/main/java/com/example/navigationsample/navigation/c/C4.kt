package com.example.navigationsample.navigation.c

import com.example.navigationsample.R
import com.example.navigationsample.c.C4Router
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.navigation.MainRouter

class C4RouterImpl(
    private val mainRouter: MainRouter
) : C4Router {

    override fun openC5() {
        mainRouter.navigate(C5Destination)
    }

    override fun pop() {
        mainRouter.pop()
    }
}


object C4Destination : FragmentDestinationById() {
    override val destinationId = R.id.c4Fragment
}