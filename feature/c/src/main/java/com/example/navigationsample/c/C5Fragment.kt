package com.example.navigationsample.c

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.navigationsample.feature.c.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.android.ext.android.inject

class C5Fragment : BaseFragment(R.layout.fragment) {
    private val router: C5Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "C5"

            nextBtn.setOnClickListener {
                router.popToC1()
            }

            specialBtn.apply {
                isVisible = true
                text = "Pop to C3"
                setOnClickListener {
                    router.popToC3()
                }
            }
        }

        addBackPressedCallback { router.pop() }
    }
}


interface C5Router {
    fun popToC1()
    fun popToC3()
    fun pop()
}