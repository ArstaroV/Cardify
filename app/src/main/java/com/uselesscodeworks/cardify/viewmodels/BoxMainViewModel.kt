package com.uselesscodeworks.cardify.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.models.Box
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BoxMainViewModel(private val repository: BoxRepository) : ViewModel() {

    val boxes : LiveData<List<Box>> = repository.getAllBoxes()

    fun addBox(box: Box) {
        GlobalScope.launch {
            repository.addBox(box)
        }
    }

    fun deleteBox(box : Box) {
        GlobalScope.launch {
            repository.deleteBox(box)
        }
    }
}

