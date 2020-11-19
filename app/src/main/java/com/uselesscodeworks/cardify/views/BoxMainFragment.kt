package com.uselesscodeworks.cardify.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uselesscodeworks.cardify.viewmodels.BoxMainViewModel
import com.uselesscodeworks.cardify.R

class BoxMainFragment : Fragment() {

    companion object {
        fun newInstance() = BoxMainFragment()
    }

    private lateinit var viewModel: BoxMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.box_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BoxMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}