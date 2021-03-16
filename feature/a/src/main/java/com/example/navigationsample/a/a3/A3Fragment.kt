package com.example.navigationsample.a.a3

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

class A3Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A3ViewModel by viewModel()
    private val sharedVm: SharedViewModel by navGraphViewModels(R.id.a_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showSnackbar(sharedVm.text)
        sharedVm.text = "A3"

        FragmentBinding.bind(view).apply {
            fragText.text = "A3"

            nextBtn.setOnClickListener { vm.openA4() }
        }

        addBackPressedCallback { vm.pop() }
    }
}
