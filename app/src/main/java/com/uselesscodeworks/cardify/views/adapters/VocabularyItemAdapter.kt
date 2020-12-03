package com.uselesscodeworks.cardify.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.models.Vocabulary
import kotlinx.android.synthetic.main.vocabulary_item.view.*

class VocabularyItemAdapter(private val vocabulary_list : MutableList<Vocabulary>) : RecyclerView.Adapter<VocabularyItemAdapter.VocabularyItemViewHolder>() {
    class VocabularyItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sourceVocabulary: EditText = itemView.source_vocabulary
        val targetVocabulary: EditText = itemView.target_vocabulary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.vocabulary_item,
            parent,
            false)
        return VocabularyItemViewHolder(itemView)
    }

    override fun getItemCount() = vocabulary_list.size

    override fun onBindViewHolder(holder: VocabularyItemViewHolder, position: Int) {
        val currentItem = vocabulary_list[position]
        holder.sourceVocabulary.setText(currentItem.sourceVocabulary)
        holder.targetVocabulary.setText(currentItem.targetVocabulary)
    }
}