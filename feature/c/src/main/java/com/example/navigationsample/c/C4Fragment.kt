package com.example.navigationsample.c

import android.os.Bundle
import android.view.View
import com.example.navigationsample.feature.c.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.extensions.addBackPressedCallback
import org.koin.android.ext.android.inject

class C4Fragment : BaseFragment(R.layout.fragment) {
    private val router: C4Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "C4"

            nextBtn.setOnClickListener {
                router.openC5()
            }
        }

        addBackPressedCallback { router.pop() }
    }
}


interface C4Router {
    fun openC5()
    fun pop()
}