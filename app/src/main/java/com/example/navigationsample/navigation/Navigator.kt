package com.example.navigationsample.navigation

import com.example.navigationsample.MainActivity
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach

// todo просто передает команды в активити, подумать над именем

typealias NavCommand = MainActivity.() -> Unit

class Navigator {
    private val _navFlow = MutableSharedFlow<NavCommand>(replay = Int.MAX_VALUE)
    val navFlow = _navFlow
        .asSharedFlow()
        .onEach { _navFlow.resetReplayCache() }

    fun execute(navCommand: NavCommand) {
        _navFlow.tryEmit(navCommand)
    }
}