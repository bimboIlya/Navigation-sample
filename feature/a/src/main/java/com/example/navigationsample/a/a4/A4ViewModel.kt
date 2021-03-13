package com.example.navigationsample.a.a4

import androidx.lifecycle.ViewModel

class A4ViewModel(private val router: A4Router) : ViewModel() {
    fun pop() = router.pop()

    fun popToA1() = router.popToA1()
}