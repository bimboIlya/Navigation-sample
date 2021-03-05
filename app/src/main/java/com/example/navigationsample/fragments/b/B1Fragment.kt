package com.example.navigationsample.fragments.b

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.navigation.MainRouter
import com.example.navigationsample.util.addBackPressedCallback
import com.example.navigationsample.util.argsOf
import org.koin.android.ext.android.inject

class B1Fragment : BaseFragment(R.layout.fragment) {
    private val router: B1Router by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "B1"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            router.openB2WithDestination(50)
//            router.openB2(45)
//            router.openB2WithNavArgs(40)
//            router.openB2WithNavDirection(35)
        }

        addBackPressedCallback { requireActivity().finish() }
    }
}


class B1Router(
    private val mainRouter: MainRouter
) {
    fun openB2(size: Int) {
        mainRouter.navigate(
            destinationId = R.id.b2Fragment,
            args = argsOf { b2Size = size }
        )
    }

    fun openB2WithNavArgs(size: Int) {
        val args = B2FragmentArgs(b2ListSize = size)
        mainRouter.navigate(
            destinationId = R.id.b2Fragment,
            args = args.toBundle()
        )
    }

    fun openB2WithNavDirection(size: Int) {
        val direction = B1FragmentDirections.actionB1FragmentToB2Fragment(size)
        mainRouter.navigate(direction)
    }

    fun openB2WithDestination(size: Int) {
        mainRouter.navigate(B2Destination(size))
    }
}