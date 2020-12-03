package com.uselesscodeworks.cardify.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.models.Vocabulary

class VocabularyViewModel : ViewModel() {
    val vocs = MutableLiveData<MutableList<Vocabulary>>()

    init {
        for (i in 0 until 20) {
            val element = Vocabulary(i.toString(), (i*2).toString())
            vocs.value?.add(element)
        }
    }
}