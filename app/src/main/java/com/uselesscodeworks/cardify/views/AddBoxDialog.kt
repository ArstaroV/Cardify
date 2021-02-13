package com.uselesscodeworks.cardify.views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.InputFilter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.databinding.BoxDialogBinding

class AddBoxDialog(private val fragment: Fragment) : DialogFragment() {
    private lateinit var listener: AddBoxDialogListener

    interface AddBoxDialogListener {
        fun onAddBoxClick(boxName: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        listener = fragment as AddBoxDialogListener
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val binding = DataBindingUtil.inflate<BoxDialogBinding>(
                inflater,
                R.layout.box_dialog,
                null,
                false
            )
            binding.BoxName.filters += InputFilter.LengthFilter(30)
            builder.setView(binding.root)
            binding.addFab.setOnClickListener {
                if (binding.BoxName.text.isNotBlank()) {
                    listener.onAddBoxClick(binding.BoxName.text.toString())
                    dialog?.cancel()
                }
            }
            binding.cancelButton.setOnClickListener {
                dialog?.cancel()
            }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
