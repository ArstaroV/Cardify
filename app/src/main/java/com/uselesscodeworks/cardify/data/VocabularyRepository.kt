package com.uselesscodeworks.cardify.data

import androidx.lifecycle.LiveData
import com.uselesscodeworks.cardify.models.Vocabulary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VocabularyRepository(private val vocabularyDao: VocabularyDao) {
    suspend fun addVocabulary(vocabel: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.addVocabulary(vocabel)
            }
        }
    }

    suspend fun deleteVocabulary(vocabel: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.addVocabulary(vocabel)
            }
        }
    }

    suspend fun updateVocabulary(vocabel: Vocabulary) {
        coroutineScope {
            launch {
                vocabularyDao.updateVocabulary(vocabel)
            }
        }
    }

    fun getVocabelsByBoxId(boxId: Int): LiveData<List<Vocabulary>> = vocabularyDao.getVocabelsByBoxId(boxId)

    suspend fun getAllVocabels(): LiveData<List<Vocabulary>> = withContext(Dispatchers.IO) {
        vocabularyDao.getAllVocabels()
    }
}