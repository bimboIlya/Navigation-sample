package com.example.navigationsample.c

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.navigationsample.feature.c.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.extensions.addBackPressedCallback
import com.example.navigationsample.ui.pushDeeplinkNotification
import org.koin.android.ext.android.inject

class C1Fragment : BaseFragment(R.layout.fragment) {
    private val router: C1Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "C1"

            nextBtn.setOnClickListener {
                router.openC2()
            }

            specialBtn.apply {
                isVisible = true
                text = "DP Notification"
                setOnClickListener {
                    pushDeeplinkNotification()
                }
            }
        }

        addBackPressedCallback { requireActivity().finish() }
    }
}


interface C1Router {
    fun openC2()
}