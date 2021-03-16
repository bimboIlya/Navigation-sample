package com.example.navigationsample.c

import android.os.Bundle
import android.view.View
import com.example.navigationsample.feature.c.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.extensions.Args
import com.example.navigationsample.ui.extensions.addBackPressedCallback
import com.example.navigationsample.ui.extensions.args
import com.example.navigationsample.ui.extensions.getStringOrThrow
import org.koin.android.ext.android.inject

const val C3_TEXT_KEY = "c3_text"

var Args.c3Text: String
    get() = getStringOrThrow(C3_TEXT_KEY)
    set(value) = putString(C3_TEXT_KEY, value)


class C3Fragment : BaseFragment(R.layout.fragment) {
    private val router: C3Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "C3 arg: ${args.c3Text}"

            nextBtn.setOnClickListener {
                router.openC4()
            }
        }

        addBackPressedCallback { router.pop() }
    }
}


interface C3Router {
    fun openC4()
    fun pop()
}