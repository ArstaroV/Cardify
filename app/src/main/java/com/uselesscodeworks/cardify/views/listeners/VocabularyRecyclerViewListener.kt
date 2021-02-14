package com.uselesscodeworks.cardify.views.listeners

import com.uselesscodeworks.cardify.models.Vocabulary

interface VocabularyRecyclerViewListener {
    fun onItemHold(vocabulary: Vocabulary)
    fun onLostFocus(vocabulary: Vocabulary)
}