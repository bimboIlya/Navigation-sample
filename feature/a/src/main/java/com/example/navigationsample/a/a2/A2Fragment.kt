package com.example.navigationsample.a.a2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.navigationsample.feature.a.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class A2Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A2ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "A2"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            vm.navigateToA3()
        }

        view.findViewById<Button>(R.id.special_btn).apply {
            isVisible = true
            text = "A4 With delay"
            setOnClickListener {
                vm.navigateToA4WithDelay()
            }
        }

        addBackPressedCallback { vm.pop() }
    }

}
