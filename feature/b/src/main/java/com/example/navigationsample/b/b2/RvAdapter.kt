package com.example.navigationsample.b.b2

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationsample.feature.b.R
import com.example.navigationsample.ui.extensions.inflate

class RvAdapter(private val size: Int) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_rv)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    override fun getItemCount(): Int = size


    class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(position: Int) {
            v.findViewById<TextView>(R.id.rv_text).text = "poop$position"
        }
    }
}