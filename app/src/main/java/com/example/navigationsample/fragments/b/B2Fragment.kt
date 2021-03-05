package com.example.navigationsample.fragments.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationsample.R
import com.example.navigationsample.fragments.BaseFragment
import com.example.navigationsample.navigation.FragmentDestination
import com.example.navigationsample.util.Args
import com.example.navigationsample.util.args
import com.example.navigationsample.util.argsOf
import com.example.navigationsample.util.getIntOrThrow

private const val B2SIZE_KEY = "b2size_key"

var Args.b2Size: Int
    get() = getIntOrThrow(B2SIZE_KEY)
    set(value) = putInt(B2SIZE_KEY, value)


class B2Fragment : BaseFragment(R.layout.fragment_b2) {
    private val navArgs by navArgs<B2FragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
//            adapter = RvAdapter(navArgs.b2ListSize)
            adapter = RvAdapter(args.b2Size)
        }
    }
}


class B2Destination(
    private val size: Int
) : FragmentDestination() {

    override val destinationId: Int = R.id.b2Fragment

    override val args = argsOf {
        b2Size = size
    }
}


class RvAdapter(private val size: Int) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_rv, parent, false)

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
