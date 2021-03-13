package com.example.navigationsample.navigation.about

import android.net.Uri
import androidx.core.net.toUri
import com.example.navigationsample.navigation.FragmentDestinationByDeeplink

object AboutDestinationDeeplink : FragmentDestinationByDeeplink() {
    override val deeplinkUri: Uri = "app.poop://about".toUri()
}