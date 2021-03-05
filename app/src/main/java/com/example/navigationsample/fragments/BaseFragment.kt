package com.example.navigationsample.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

open class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLifecycle("onCreate()")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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