package com.example.navigationsample.ui.extensions

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar

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

fun Fragment.showSnackbar(text: String) {
    Snackbar.make(requireView(), text, Snackbar.LENGTH_SHORT)
        .setAction("Dismiss") {  }
        .show()
}

fun Fragment.launchWhenViewResumed(block: suspend () -> Unit) {
    viewLifecycleOwner.lifecycleScope.launchWhenResumed { block() }
}

fun Fragment.launchWhenFragmentResumed(block: suspend () -> Unit) {
    lifecycleScope.launchWhenResumed { block() }
}