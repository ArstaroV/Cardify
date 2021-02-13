package com.uselesscodeworks.cardify.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.databinding.BoxItemBinding
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.views.listeners.RecyclerViewClickListener

class BoxItemAdapter(private val boxList : List<Box>, private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<BoxItemAdapter.BoxItemViewHolder>() {
    class BoxItemViewHolder(val binding : BoxItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<BoxItemBinding>(inflater,R.layout.box_item,
            parent,
            false )
        return BoxItemViewHolder(binding)
    }

    override fun getItemCount() = boxList.size

    override fun onBindViewHolder(holder: BoxItemViewHolder, position: Int) {
        holder.binding.box = boxList[position]
        holder.binding.boxButton.setOnClickListener {
            listener.onItemClick(holder.binding.root, boxList[position])
        }
        holder.binding.boxButton.setOnLongClickListener {
            listener.onItemHold(holder.binding.root, boxList[position])
            return@setOnLongClickListener true
        }

    }
}
