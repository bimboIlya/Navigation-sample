package com.example.navigationsample.about

import android.os.Bundle
import android.view.View
import com.example.navigationsample.feature.about.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding

class AboutFragment : BaseFragment(R.layout.fragment) {

    override val bottomBarIsVisible = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "About"
        }
    }
}
