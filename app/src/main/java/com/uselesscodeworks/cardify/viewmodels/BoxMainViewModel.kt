package com.uselesscodeworks.cardify.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uselesscodeworks.cardify.models.Box

class BoxMainViewModel : ViewModel() {
    val boxes = MutableLiveData<MutableList<Box>>()

    init {
        for (i in 0 until 20) {
            val element = Box(i.toString())
            boxes.value?.add(element)
        }
    }
}