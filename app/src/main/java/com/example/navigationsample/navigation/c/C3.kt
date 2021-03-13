package com.example.navigationsample.navigation.c

import android.net.Uri
import androidx.core.net.toUri
import com.example.navigationsample.R
import com.example.navigationsample.c.C3Router
import com.example.navigationsample.c.c3Text
import com.example.navigationsample.navigation.FragmentDestinationByDeeplink
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.ui.util.argsOf

class C3RouterImpl(
    private val mainRouter: MainRouter
) : C3Router {

    override fun openC4() {
        mainRouter.navigate(C4Destination)
    }

    override fun pop() {
        mainRouter.pop()
    }
}

class C3Destination(
    private val text: String
) : FragmentDestinationById() {

    override val destinationId: Int = R.id.c3Fragment

    override val args = argsOf { c3Text = text }
}

class C3DestinationDeeplink(
    text: String
) : FragmentDestinationByDeeplink() {
    override val deeplinkUri: Uri = "app.poop://c3/$text".toUri()

}