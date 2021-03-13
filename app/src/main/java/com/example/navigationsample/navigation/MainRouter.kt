package com.example.navigationsample.navigation

import androidx.navigation.navOptions
import com.example.navigationsample.MainActivity
import com.example.navigationsample.R
import timber.log.Timber
import kotlin.reflect.KClass

interface MainRouter {

    fun navigate(destination: Destination)

    fun pop()

    fun popUpTo(destinationClass: KClass<out FragmentDestination>, inclusive: Boolean = false)

    fun popToRoot(inclusive: Boolean = false)
}


class MainRouterImpl(
    private val navigator: Navigator
) : MainRouter {

    override fun navigate(destination: Destination) {
        navigator.sendCommand {
            when (destination) {
                is FragmentDestination -> navigateFragment(destination)
                is SystemDestination -> navigateSystem(destination)
            }
        }
    }

    override fun pop() {
        navigator.sendCommand {
            currentNavController.popBackStack()
        }
    }

    override fun popUpTo(destinationClass: KClass<out FragmentDestination>, inclusive: Boolean) {
        navigator.sendCommand {
            val destination =
                currentNavController.graph.find { it.label == destinationClass.simpleName }
            if (destination?.id == null) {
                popToRoot(inclusive)
                return@sendCommand
            }

            currentNavController.popBackStack(destination.id, inclusive)
        }
    }

    override fun popToRoot(inclusive: Boolean) {
        navigator.sendCommand {
            val startId = currentNavController.graph.startDestination
            currentNavController.popBackStack(startId, inclusive)
        }
    }

    private fun MainActivity.navigateFragment(destination: FragmentDestination) {
        when (destination) {
            is FragmentDestinationById -> currentNavController.navigate(
                destination.destinationId,
                destination.args,
                destination.navOptions
            )

            is FragmentDestinationByDeeplink -> currentNavController.navigate(
                destination.deeplinkUri,
                destination.navOptions
            )
        }

        addDestinationLabel(destination)
    }

    private fun MainActivity.addDestinationLabel(destination: FragmentDestination) {
        currentNavController.currentDestination?.label =
            destination::class.simpleName?.removeSuffix("Deeplink")
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