package com.example.navigationsample.fragments.c

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment

class C2Fragment : BaseFragment(R.layout.fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.frag_text).text = "C2"

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {

        }
    }
}