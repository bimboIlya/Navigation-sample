package com.example.navigationsample.navigation.c

import com.example.navigationsample.R
import com.example.navigationsample.c.C1Router
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.navigation.MainRouter

class C1RouterImpl(
    private val mainRouter: MainRouter
) : C1Router {

    override fun openC2() {
        mainRouter.navigate(C2Destination)
    }
}


object C1Destination : FragmentDestinationById() {
    override val destinationId = R.id.c1Fragment
}
