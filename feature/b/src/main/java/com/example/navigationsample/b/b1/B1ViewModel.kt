package com.example.navigationsample.b.b1

import androidx.lifecycle.ViewModel

class B1ViewModel(
    private val router: B1Router
) : ViewModel() {

    fun openB2(size: Int) {
        router.openB2(size)
    }

    fun openAbout() {
        router.openAboutWithDeeplink()
    }
}