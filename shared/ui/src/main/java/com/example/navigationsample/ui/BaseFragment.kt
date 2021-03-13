package com.example.navigationsample.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    open val bottomBarIsVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifecycle("onCreate()")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav).isVisible = bottomBarIsVisible
        super.onViewCreated(view, savedInstanceState)
        logLifecycle("onViewCreated()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logLifecycle("onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle("onDestroy()")
    }

    private fun logLifecycle(name: String) {
        Timber.d("${javaClass.simpleName} $name")
    }
}