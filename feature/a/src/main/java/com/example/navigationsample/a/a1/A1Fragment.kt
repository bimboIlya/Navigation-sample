package com.example.navigationsample.a.a1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.navigationsample.feature.a.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class A1Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A1ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "A1"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            vm.openA2()
        }

        view.findViewById<Button>(R.id.special_btn).apply {
            isVisible = true
            text = "Gallery"
            setOnClickListener {
                vm.pickPic()
            }
        }

        addBackPressedCallback { requireActivity().finish() }
    }
}
