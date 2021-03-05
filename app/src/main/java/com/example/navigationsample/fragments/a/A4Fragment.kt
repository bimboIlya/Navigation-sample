package com.example.navigationsample.fragments.a

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.util.addBackPressedCallback
import com.example.navigationsample.navigation.MainRouter
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


class A4ViewModel(private val router: A4Router) : ViewModel() {
    fun pop() = router.pop()

    fun popToA1() = router.popToA1()
}


class A4Router(private val mainRouter: MainRouter) {
    fun pop() = mainRouter.pop()

    fun popToA1() = mainRouter.popToRoot()
}