package com.uselesscodeworks.cardify.views.adapters

import android.view.View
import com.uselesscodeworks.cardify.models.Box

interface RecyclerViewClickListener {
    fun OnItemClick(view:View, box: Box)
    fun OnItemHold(view:View, box: Box)
}