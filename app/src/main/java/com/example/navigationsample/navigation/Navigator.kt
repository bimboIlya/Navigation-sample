package com.example.navigationsample.navigation

import com.example.navigationsample.MainActivity
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach

typealias NavCommand = MainActivity.() -> Unit

class Navigator {
    private val _navFlow = MutableSharedFlow<NavCommand>(replay = Int.MAX_VALUE)
    val navFlow = _navFlow
        .asSharedFlow()
        .onEach { _navFlow.resetReplayCache() }

    fun sendCommand(navCommand: NavCommand) {
        _navFlow.tryEmit(navCommand)
    }
}