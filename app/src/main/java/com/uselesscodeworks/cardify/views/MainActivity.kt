package com.uselesscodeworks.cardify.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.models.Vocabulary
import com.uselesscodeworks.cardify.views.adapters.BoxItemAdapter
import com.uselesscodeworks.cardify.views.adapters.VocabularyItemAdapter
import kotlinx.android.synthetic.main.box_main_fragment.*
import kotlinx.android.synthetic.main.vocabulary_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testList = genDummy(50)
        vocabulary_list.adapter = VocabularyItemAdapter(testList)
        vocabulary_list.layoutManager = LinearLayoutManager(this)
    }

    private fun genDummy(size: Int): MutableList<Vocabulary> {
        val boxes = ArrayList<Vocabulary>()
        for (i in 0 until size) {
            val element = Vocabulary(i.toString(), (i*2).toString())
            boxes.add(element)
        }
        return boxes
    }

}