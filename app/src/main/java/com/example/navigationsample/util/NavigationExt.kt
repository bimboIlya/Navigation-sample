package com.example.navigationsample.util

import androidx.navigation.NavOptions

fun NavOptions.newBuilder(): NavOptions.Builder =
    NavOptions.Builder()
        .setLaunchSingleTop(shouldLaunchSingleTop())
        .setPopUpTo(popUpTo, isPopUpToInclusive)
        .setEnterAnim(enterAnim)
        .setExitAnim(exitAnim)
        .setPopEnterAnim(popEnterAnim)
        .setPopExitAnim(popExitAnim)