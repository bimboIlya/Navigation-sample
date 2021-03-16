package com.example.navigationsample.a.a4

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.example.navigationsample.a.SharedViewModel
import com.example.navigationsample.feature.a.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.databinding.FragmentBinding
import com.example.navigationsample.ui.extensions.addBackPressedCallback
import com.example.navigationsample.ui.extensions.showSnackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class A4Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A4ViewModel by viewModel()
    private val sharedVm: SharedViewModel by navGraphViewModels(R.id.a_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showSnackbar(sharedVm.text)
        sharedVm.text = "A4"

        FragmentBinding.bind(view).apply {
            fragText.text = "A4"

            nextBtn.setOnClickListener { vm.popToA1() }
        }

        addBackPressedCallback { vm.pop() }
    }
}
