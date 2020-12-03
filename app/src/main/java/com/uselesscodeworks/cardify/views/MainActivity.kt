package com.uselesscodeworks.cardify.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.views.adapters.BoxItemAdapter
import kotlinx.android.synthetic.main.box_main_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testList = genDummy(50)
        box_list.adapter = BoxItemAdapter(testList)
        box_list.layoutManager = LinearLayoutManager(this)
    }

    private fun genDummy(size: Int): MutableList<Box> {
        val boxes = ArrayList<Box>()
        for (i in 0 until 20) {
            val element = Box(i.toString())
            boxes.add(element)
        }
        return boxes
    }

}