package com.uselesscodeworks.cardify.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.databinding.BoxItemBinding
import com.uselesscodeworks.cardify.databinding.VocabularyItemBinding
import com.uselesscodeworks.cardify.models.Vocabulary
import kotlinx.android.synthetic.main.vocabulary_item.view.*

class VocabularyItemAdapter(private val vocabulary_list : List<Vocabulary>) : RecyclerView.Adapter<VocabularyItemAdapter.VocabularyItemViewHolder>() {
    class VocabularyItemViewHolder(val binding: VocabularyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val sourceVocabulary: EditText = itemView.source_vocabulary
        val targetVocabulary: EditText = itemView.target_vocabulary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VocabularyItemBinding>(inflater,R.layout.vocabulary_item,
            parent,
            false )
        return VocabularyItemViewHolder(binding)
    }

    override fun getItemCount() = vocabulary_list.size

    override fun onBindViewHolder(holder: VocabularyItemViewHolder, position: Int) {
        holder.binding.vocabel = vocabulary_list[position]
    }
}