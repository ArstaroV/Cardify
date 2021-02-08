package com.uselesscodeworks.cardify.views.adapters

import com.uselesscodeworks.cardify.models.Vocabulary

interface VocabularyRecyclerViewListener {
    fun onLostFocus(vocabel : Vocabulary, position: Int)
}