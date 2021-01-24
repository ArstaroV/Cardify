package com.uselesscodeworks.cardify.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.models.Box

class BoxMainViewModel : ViewModel() {

    private val tempList = mutableListOf<Box>()
    val boxes = MutableLiveData<List<Box>>()

    init {
        for (i in 0 until 20) {
            val element = Box(i.toString())
            tempList.add(element)
        }
        for (i in "HELLO") {
            val element = Box(i.toString())
            tempList.add(element)
        }
        boxes.value = tempList
    }
    fun AddBox() {
        //boxes.value.toMutableList().add(Box("New Box"))
        boxes.value = boxes.value?.plus(Box("New Box"))
    }
}