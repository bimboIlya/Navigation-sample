package com.example.navigationsample.a.a3

import androidx.lifecycle.ViewModel

class A3ViewModel(
    private val router: A3Router
) : ViewModel() {

    fun openA4() = router.openA4()

    fun pop() = router.pop()
}