package com.example.navigationsample.fragments.a

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.util.addBackPressedCallback
import com.example.navigationsample.navigation.ImgChooserDestination
import com.example.navigationsample.navigation.MainRouter
import org.koin.androidx.viewmodel.ext.android.viewModel

class A1Fragment : BaseFragment(R.layout.fragment) {
    private val vm: A1ViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "A1"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            vm.navigateToA2()
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


class A1ViewModel(
    private val router: A1Router
) : ViewModel() {

    fun navigateToA2() {
        router.openA2()
    }

    fun pickPic() = router.pickPick()
}


class A1Router(
    private val mainRouter: MainRouter
) {
    fun openA2() = mainRouter.navigate(R.id.a2Fragment)

    fun pickPick() = mainRouter.navigate(ImgChooserDestination)
}