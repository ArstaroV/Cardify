package com.uselesscodeworks.cardify.data

import androidx.lifecycle.LiveData
import com.uselesscodeworks.cardify.models.Vocabulary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VocabularyRepository(private val vocabularyDao: VocabularyDao) {
    suspend fun addVocabulary(vocabulary: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.addVocabulary(vocabulary)
            }
        }
    }

    suspend fun deleteVocabulary(vocabulary: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.deleteVocabulary(vocabulary)
            }
        }
    }
    
    suspend fun updateVocabulary(vocabulary: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.updateVocabulary(vocabulary)
            }
        }
    }

    fun getVocabelsByBoxId(boxId: Int): LiveData<List<Vocabulary>> =
        vocabularyDao.getVocabelsByBoxId(boxId)

    suspend fun getAllVocabels(): LiveData<List<Vocabulary>> = withContext(Dispatchers.IO) {
        vocabularyDao.getAllVocabels()
    }
}