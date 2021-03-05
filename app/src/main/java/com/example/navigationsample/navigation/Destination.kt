package com.example.navigationsample.navigation

import android.content.Intent
import android.provider.MediaStore
import com.example.navigationsample.MainActivity
import com.example.navigationsample.util.Args

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


abstract class FragmentDestination : Destination {
    abstract val destinationId: Int
    open val args: Args? = null
    open val navOptions = DefaultNavOptions
}
