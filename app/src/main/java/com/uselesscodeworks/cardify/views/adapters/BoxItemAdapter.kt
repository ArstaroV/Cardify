package com.uselesscodeworks.cardify.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.models.Box
import kotlinx.android.synthetic.main.box_item.view.*
import kotlinx.android.synthetic.main.box_main_fragment.view.*

class BoxItemAdapter(private val boxList : MutableList<Box>) : RecyclerView.Adapter<BoxItemAdapter.BoxItemViewHolder>() {
    class BoxItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val boxName: TextView = itemView.box_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.box_item,
            parent,
            false)
        return BoxItemViewHolder(itemView)
    }

    override fun getItemCount() = boxList.size

    override fun onBindViewHolder(holder: BoxItemViewHolder, position: Int) {
        val currentItem = boxList[position]
        holder.boxName.text = currentItem.name
    }
}