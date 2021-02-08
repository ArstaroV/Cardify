package com.uselesscodeworks.cardify.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.data.VocabularyRepository
import com.uselesscodeworks.cardify.models.Vocabulary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VocabularyViewModel(private val repository: VocabularyRepository) : ViewModel() {
    var vocabels : LiveData<List<Vocabulary>> = repository.getVocabelsByBoxId(CardifyDatabase.getInstance(null).selectedBoxId)

    fun addVocabulary(vocabulary: Vocabulary) {
        GlobalScope.launch {
            repository.addVocabulary(vocabulary)
        }
    }
    fun updateVocabulary(vocabulary: Vocabulary, position: Int){
        GlobalScope.launch {
            repository.updateVocabulary(vocabulary)
        }
    }
}