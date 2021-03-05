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

class A3Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A3ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "A3"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            vm.openA4()
        }

        addBackPressedCallback { vm.pop() }
    }
}


class A3ViewModel(
    private val router: A3Router
) : ViewModel() {

    fun openA4() = router.openA4()

    fun pop() = router.pop()
}

class A3Router(
    private val mainRouter: MainRouter
) {
    fun openA4() = mainRouter.navigate(R.id.a4Fragment)

    fun pop() = mainRouter.pop()
}