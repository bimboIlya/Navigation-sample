package com.example.navigationsample.a.a4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.navigationsample.feature.a.R
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.util.addBackPressedCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class A4Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A4ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "A4"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            vm.popToA1()
        }

        addBackPressedCallback { vm.pop() }
    }
}
