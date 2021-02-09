package com.uselesscodeworks.cardify.views.adapters

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.sip.SipSession
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.BoxDao
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.databinding.BoxDialogBinding
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.viewmodels.BoxMainViewModel
import kotlinx.android.synthetic.main.box_dialog.*

class AddBoxDialog : DialogFragment() {

    var listener: Listener? = null
    var boxText = ""

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity)
        val rootView = activity?.layoutInflater?.inflate(R.layout.box_dialog, null)
        isCancelable = false
        val boxNameTextView: TextView? = rootView?.findViewById(R.id.BoxName)
        val addButton: ImageButton? = rootView?.findViewById(R.id.add_fab)
        val cancelButton: ImageButton? = rootView?.findViewById(R.id.cancelButton)
        if (boxText.isNotBlank()){
            boxNameTextView?.text = boxText
        }
        addButton?.setOnClickListener{
            Toast.makeText(requireContext(), "You've added nothing!", Toast.LENGTH_SHORT).show()
            // TODO: addbox-function
        }
        cancelButton?.setOnClickListener{
            Toast.makeText(requireContext(), "You've canceled the process", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        builder.setView(rootView)
        return builder.create()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    interface Listener{
        // TODO: Callback
    }
/*
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val binding = DataBindingUtil.inflate<BoxDialogBinding>(inflater, R.layout.box_dialog, null, false)
            builder.setView(binding.root)
                .setPositiveButton("Add", DialogInterface.OnClickListener{
                        _,_ ->
                    Toast.makeText(requireContext(), binding.BoxName.text, Toast.LENGTH_SHORT).show()
                    val addedBox = BoxName.text.toString()
                    val box = Box(addedBox)
                    mBoxMainViewModel.addBox(box)
                })

                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        _, _ -> dialog?.cancel() })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
*/
}
