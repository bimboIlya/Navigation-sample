package com.example.navigationsample.c

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.navigationsample.feature.c.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.android.ext.android.inject

class C2Fragment : BaseFragment(R.layout.fragment) {
    private val router: C2Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "C2"

            nextBtn.setOnClickListener {
                router.openC3()
            }

            specialBtn.apply {
                isVisible = true
                text = "C3 Deeplink"
                setOnClickListener {
                    router.openC3Deeplink()
                }
            }
        }

        addBackPressedCallback { router.pop() }
    }
}


interface C2Router {
    fun openC3()
    fun openC3Deeplink()
    fun pop()
}