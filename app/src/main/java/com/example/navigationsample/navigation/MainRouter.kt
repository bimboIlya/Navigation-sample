package com.example.navigationsample.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.example.navigationsample.MainActivity
import com.example.navigationsample.R
import timber.log.Timber

interface MainRouter {

    // сомнительно
    fun navigate(navDirections: NavDirections, navOptions: NavOptions = DefaultNavOptions)

    fun navigate(destination: Destination)

    fun navigate(
        @IdRes destinationId: Int,
        args: Bundle? = null,
        navOptions: NavOptions = DefaultNavOptions
    )

    fun pop()

    fun popUpTo(@IdRes destinationId: Int, inclusive: Boolean = false)

    fun popToRoot(inclusive: Boolean = false)
}


class MainRouterImpl(
    private val navigator: Navigator
) : MainRouter {

    override fun navigate(navDirections: NavDirections, navOptions: NavOptions) {
        navigator.execute {
            currentNavController.navigate(navDirections, navOptions)
        }
    }

    override fun navigate(destination: Destination) {
        navigator.execute {
            when (destination) {
                is FragmentDestination -> navigateFragment(destination)
                is SystemDestination -> navigateSystem(destination)
            }
        }
    }

    override fun navigate(
        @IdRes destinationId: Int,
        args: Bundle?,
        navOptions: NavOptions
    ) {
        navigator.execute {
            currentNavController.navigate(
                destinationId,
                args,
                navOptions
            )
        }
    }

    override fun pop() {
        navigator.execute {
            currentNavController.popBackStack()
        }
    }

    override fun popUpTo(@IdRes destinationId: Int, inclusive: Boolean) {
        navigator.execute {
            currentNavController.popBackStack(destinationId, inclusive)
        }
    }

    override fun popToRoot(inclusive: Boolean) {
        navigator.execute {
            val startId = currentNavController.graph.startDestination
            currentNavController.popBackStack(startId, inclusive)
        }
    }

    private fun MainActivity.navigateFragment(destination: FragmentDestination) {
        currentNavController.navigate(
            destination.destinationId,
            destination.args,
            destination.navOptions
        )
    }

    private fun MainActivity.navigateSystem(destination: SystemDestination) {
        val intent = destination.createIntent(this)

        try {
            startActivity(intent)
        } catch (e: RuntimeException) {
            Timber.e("failed starting intent")
        }
    }
}

val DefaultNavOptions = navOptions {
    anim {
        enter = R.anim.nav_default_enter_anim
        exit = R.anim.nav_default_exit_anim
        popEnter = R.anim.nav_default_pop_enter_anim
        popExit = R.anim.nav_default_pop_exit_anim
    }
}