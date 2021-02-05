package com.uselesscodeworks.cardify.data
import android.app.Application
import androidx.lifecycle.LiveData
import com.uselesscodeworks.cardify.models.Box
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class BoxRepository(private val boxDao : BoxDao) {

    suspend fun addBox(box: Box){
        coroutineScope {
            launch {
                boxDao.addBox(box)
            }
        }
    }
    fun getAllBoxes() : LiveData<List<Box>> = boxDao.getAllBoxes()

}
