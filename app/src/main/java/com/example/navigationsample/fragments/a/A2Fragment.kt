package com.example.navigationsample.fragments.a

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.util.addBackPressedCallback
import com.example.navigationsample.navigation.MainRouter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
            text = "With delay"
            setOnClickListener {
                vm.navigateToA4WithDelay()
            }
        }

        addBackPressedCallback { vm.pop() }
    }

}


class A2ViewModel(
    private val router: A2Router
) : ViewModel() {

    fun navigateToA3() {
        router.openA3()
    }

    fun navigateToA4WithDelay() {
        viewModelScope.launch {
            delay(3000)
            router.openA4()
        }
    }

    fun pop() = router.pop()
}


class A2Router(
    private val mainRouter: MainRouter
) {
    fun pop() = mainRouter.pop()

    fun openA3() = mainRouter.navigate(R.id.a3Fragment)

    fun openA4() = mainRouter.navigate(R.id.a4Fragment)
}