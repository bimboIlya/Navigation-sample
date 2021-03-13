package com.example.navigationsample.b.b1

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.navigationsample.feature.b.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class B1Fragment : BaseFragment(R.layout.fragment) {
    private val viewModel: B1ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBinding.bind(view).apply {
            fragText.text = "B1"

            nextBtn.setOnClickListener {
                viewModel.openB2(50)
            }

            specialBtn.apply {
                isVisible = true
                text = "Deep Link About"
                setOnClickListener {
                    viewModel.openAbout()
                }
            }
        }

        addBackPressedCallback { requireActivity().finish() }
    }
}
