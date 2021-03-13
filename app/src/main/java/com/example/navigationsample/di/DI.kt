package com.example.navigationsample.di

import com.example.navigationsample.a.a1.A1Router
import com.example.navigationsample.a.a1.A1ViewModel
import com.example.navigationsample.a.a2.A2Router
import com.example.navigationsample.a.a2.A2ViewModel
import com.example.navigationsample.a.a3.A3Router
import com.example.navigationsample.a.a3.A3ViewModel
import com.example.navigationsample.a.a4.A4Router
import com.example.navigationsample.a.a4.A4ViewModel
import com.example.navigationsample.b.b1.B1Router
import com.example.navigationsample.b.b1.B1ViewModel
import com.example.navigationsample.c.*
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.navigation.MainRouterImpl
import com.example.navigationsample.navigation.Navigator
import com.example.navigationsample.navigation.a.a1.A1RouterImpl
import com.example.navigationsample.navigation.a.a2.A2RouterImpl
import com.example.navigationsample.navigation.a.a3.A3RouterImpl
import com.example.navigationsample.navigation.a.a4.A4RouterImpl
import com.example.navigationsample.navigation.b.b1.B1RouterImpl
import com.example.navigationsample.navigation.c.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val navModule = module {
    single { Navigator() }
    single<MainRouter> { MainRouterImpl(get()) }

    factory<A1Router> { A1RouterImpl(get()) }
    factory<A2Router> { A2RouterImpl(get()) }
    factory<A3Router> { A3RouterImpl(get()) }
    factory<A4Router> { A4RouterImpl(get()) }

    factory<B1Router> { B1RouterImpl(get()) }

    factory<C1Router> { C1RouterImpl(get()) }
    factory<C2Router> { C2RouterImpl(get()) }
    factory<C3Router> { C3RouterImpl(get()) }
    factory<C4Router> { C4RouterImpl(get()) }
    factory<C5Router> { C5RouterImpl(get()) }
}

val vmModule = module {
    viewModel { A1ViewModel(get()) }
    viewModel { A2ViewModel(get()) }
    viewModel { A3ViewModel(get()) }
    viewModel { A4ViewModel(get()) }
    viewModel { B1ViewModel(get()) }
}