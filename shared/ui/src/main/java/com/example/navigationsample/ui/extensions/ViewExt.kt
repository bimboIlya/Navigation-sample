@file:Suppress("NOTHING_TO_INLINE")

package com.example.navigationsample.ui.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

inline fun ViewGroup.inflate(
    @LayoutRes layoutRes: Int,
    attachToRoot: Boolean = false,
): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

