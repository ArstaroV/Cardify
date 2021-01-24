package com.uselesscodeworks.cardify.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.models.Vocabulary

class VocabularyViewModel : ViewModel() {
    val vocs = mutableListOf<Vocabulary>()
    private val _vocabels = MutableLiveData<List<Vocabulary>>()
    val vocabels : LiveData<List<Vocabulary>>
            get() = _vocabels
    init {
        for (i in 0 until 20) {
            val element = Vocabulary(i.toString(), (i*2).toString())
            vocs.add(element)

        }
        _vocabels.value = vocs;
    }
}