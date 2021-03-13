package com.example.navigationsample.navigation

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import com.example.navigationsample.MainActivity
import com.example.navigationsample.ui.util.Args

interface Destination


interface SystemDestination : Destination {
    fun createIntent(activity: MainActivity): Intent
}

object ImgChooserDestination : SystemDestination {

    override fun createIntent(activity: MainActivity): Intent {
        return Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
    }
}


sealed class FragmentDestination : Destination {
    open val navOptions = DefaultNavOptions
}

abstract class FragmentDestinationById : FragmentDestination() {
    abstract val destinationId: Int
    open val args: Args? = null
}

abstract class FragmentDestinationByDeeplink : FragmentDestination() {
    abstract val deeplinkUri: Uri
}
