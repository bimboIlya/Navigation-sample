package com.example.navigationsample.navigation.b.b2

import com.example.navigationsample.R
import com.example.navigationsample.b.b2.b2Size
import com.example.navigationsample.navigation.FragmentDestinationById
import com.example.navigationsample.ui.util.argsOf

class B2Destination(
    private val size: Int
) : FragmentDestinationById() {

    override val destinationId: Int = R.id.b2Fragment

    override val args = argsOf { b2Size = size }
}