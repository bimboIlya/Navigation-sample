package com.example.navigationsample.a.a2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class A2ViewModel(
    private val router: A2Router
) : ViewModel() {

    fun navigateToA3() {
        router.openA3()
    }

    fun navigateToA4WithDelay() {
        viewModelScope.launch {
            delay(3000)
            router.openA4()
        }
    }

    fun pop() = router.pop()
}