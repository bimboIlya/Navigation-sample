package com.example.navigationsample.di

import com.example.navigationsample.fragments.a.*
import com.example.navigationsample.fragments.b.B1Router
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.MainRouterImpl
import com.example.navigationsample.navigation.Navigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val navModule = module {
    single { Navigator() }
    single<MainRouter> { MainRouterImpl(get()) }
    factory { A1Router(get()) }
    factory { A2Router(get()) }
    factory { A3Router(get()) }
    factory { A4Router(get()) }
    factory { B1Router(get()) }
}

val vmModule = module {
    viewModel { A1ViewModel(get()) }
    viewModel { A2ViewModel(get()) }
    viewModel { A3ViewModel(get()) }
    viewModel { A4ViewModel(get()) }
}