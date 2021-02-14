package com.uselesscodeworks.cardify.views.adapters

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.databinding.VocabularyItemBinding
import com.uselesscodeworks.cardify.models.Vocabulary
import com.uselesscodeworks.cardify.views.listeners.VocabularyRecyclerViewListener
import kotlinx.android.synthetic.main.vocabulary_item.view.*


class VocabularyItemAdapter(
    private val vocabulary_list: List<Vocabulary>,
    private val listener: VocabularyRecyclerViewListener
) : RecyclerView.Adapter<VocabularyItemAdapter.VocabularyItemViewHolder>() {
    inner class VocabularyItemViewHolder(val binding: VocabularyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VocabularyItemBinding>(
            inflater, R.layout.vocabulary_item,
            parent,
            false
        )
        return VocabularyItemViewHolder(binding)
    }

    override fun getItemCount() = vocabulary_list.size

    override fun onBindViewHolder(holder: VocabularyItemViewHolder, position: Int) {
        holder.binding.vocabel = vocabulary_list[position]
        holder.binding.sourceVocabulary.filters += InputFilter.LengthFilter(20)
        holder.binding.targetVocabulary.filters += InputFilter.LengthFilter(20)

        holder.binding.vocabularyLayout.setOnLongClickListener {
            listener.onItemHold(vocabulary_list[position])
            return@setOnLongClickListener true
        }
        // update data after focus on the EditText has been lost
        holder.binding.sourceVocabulary.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                vocabulary_list[position].sourceVocabulary =
                    v.source_vocabulary.text.toString()  // update the source property on the Vocabulary object from the list
                v.clearFocus()
                listener.onLostFocus(vocabulary_list[position])    // send the updated object
            }
        }
        holder.binding.targetVocabulary.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                vocabulary_list[position].targetVocabulary =
                    v.target_vocabulary.text.toString()  // update the targetVocabulary property on the Vocabulary object from the list
                v.clearFocus()
                listener.onLostFocus(vocabulary_list[position])    // send the updated object
            }
        }
    }
}