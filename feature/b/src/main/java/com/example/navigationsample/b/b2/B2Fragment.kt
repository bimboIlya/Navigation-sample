package com.example.navigationsample.b.b2

import android.os.Bundle
import android.view.View
import com.example.navigationsample.feature.b.R
import com.example.navigationsample.feature.b.databinding.FragmentB2Binding
import com.example.navigationsample.ui.BaseFragment
import com.example.navigationsample.ui.util.Args
import com.example.navigationsample.ui.util.args
import com.example.navigationsample.ui.util.getIntOrThrow

private const val B2SIZE_KEY = "b2size_key"

var Args.b2Size: Int
    get() = getIntOrThrow(B2SIZE_KEY)
    set(value) = putInt(B2SIZE_KEY, value)


class B2Fragment : BaseFragment(R.layout.fragment_b2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentB2Binding.bind(view).apply {
            recyclerView.adapter = RvAdapter(args.b2Size)
        }
    }
}
