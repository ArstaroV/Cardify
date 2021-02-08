package com.uselesscodeworks.cardify.data

import androidx.lifecycle.LiveData
import com.uselesscodeworks.cardify.models.Box
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class BoxRepository(private val boxDao: BoxDao) {
    suspend fun addBox(box: Box) {
        coroutineScope {
            launch {
                boxDao.addBox(box)
            }
        }
    }

    suspend fun deleteBox(box: Box) {
        coroutineScope {
            launch {
                boxDao.deleteBox(box)
            }
        }
    }

    fun getAllBoxes(): LiveData<List<Box>> = boxDao.getAllBoxes()

}
