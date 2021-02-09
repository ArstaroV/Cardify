package com.uselesscodeworks.cardify.views

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.viewmodels.BoxMainViewModel
import com.uselesscodeworks.cardify.views.adapters.AddBoxDialog
import kotlinx.android.synthetic.main.box_dialog.*
import kotlinx.android.synthetic.main.box_dialog.view.*
import kotlinx.android.synthetic.main.box_main_fragment.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        fab.setOnClickListener {
            val view = View.inflate(this, R.layout.box_dialog, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.add_fab.setOnClickListener {
           
            }

            view.cancelButton.setOnClickListener {
                dialog.dismiss()
            }
        }
 */

    }
}
