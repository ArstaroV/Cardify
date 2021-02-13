package com.uselesscodeworks.cardify.views.listeners

import android.view.View
import com.uselesscodeworks.cardify.models.Box

interface RecyclerViewClickListener {
    fun onItemClick(view:View, box: Box)
    fun onItemHold(view:View, box: Box)
}