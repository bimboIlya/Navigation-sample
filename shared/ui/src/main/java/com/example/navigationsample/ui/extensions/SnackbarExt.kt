package com.example.navigationsample.ui.extensions

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(text: String) {
    Snackbar.make(requireView(), text, Snackbar.LENGTH_SHORT)
        .setAction("Dismiss") {  }
        .show()
}