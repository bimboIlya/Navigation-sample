package com.example.navigationsample.fragments.c

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.util.addBackPressedCallback

class C1Fragment : BaseFragment(R.layout.fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "C1"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {

        }

        addBackPressedCallback { requireActivity().finish() }
    }
}