package com.uselesscodeworks.cardify.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.models.Box
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BoxMainViewModel(private val repository: BoxRepository) : ViewModel() {

    private val tempList = mutableListOf<Box>()
    val boxes : LiveData<List<Box>> = repository.getAllBoxes()
    //val boxes = MutableLiveData<List<Box>>()

    init {
        //boxes = repository.getAllBoxes()
//        for (i in 0 until 20) {
//            val element = Box(i.toString())
//            tempList.add(element)
//        }
//        for (i in "HELLO") {
//            val element = Box(i.toString())
//            tempList.add(element)
//        }
//        boxes.value = tempList
    }
    fun AddBox() {
        //boxes.value.toMutableList().add(Box("New Box"))
        //boxes.value = boxes.value?.plus(Box("New Box"))
        GlobalScope.launch {
            repository.addBox(Box("Another Test Box", 420))
        }
    }
}