package com.example.navigationsample.a.a1

import androidx.lifecycle.ViewModel

class A1ViewModel(
    private val router: A1Router
) : ViewModel() {

    fun openA2() {
        router.openA2()
    }

    fun pickPic() {
        router.pickPic()
    }
}