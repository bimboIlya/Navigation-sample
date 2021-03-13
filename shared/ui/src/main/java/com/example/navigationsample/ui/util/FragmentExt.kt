package com.example.navigationsample.ui.util

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

val Fragment.args: Args get() = requireArguments()

fun Fragment.addBackPressedCallback(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
): OnBackPressedCallback {
    val callback = object : OnBackPressedCallback(enabled) {
        override fun handleOnBackPressed() {
            onBackPressed.invoke()
        }
    }

    requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner, callback
    )

    return callback
}