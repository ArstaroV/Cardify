package com.uselesscodeworks.cardify.views.adapters

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.databinding.BoxDialogBinding

class AddBoxDialog : DialogFragment() {
// TODO: define Callbacks, replace vanilla button with custom
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val binding = DataBindingUtil.inflate<BoxDialogBinding>(inflater, R.layout.box_dialog, null, false)
            builder.setView(binding.root)
                .setPositiveButton("Add", DialogInterface.OnClickListener{
                        _,_ ->
                    Toast.makeText(requireContext(), binding.BoxName.text, Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        _, _ -> dialog?.cancel() })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}