package com.uselesscodeworks.cardify.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.viewmodels.VocabularyViewModel

class VocabularyFragment : Fragment() {

    companion object {
        fun newInstance() = VocabularyFragment()
    }

    private lateinit var viewModel: VocabularyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vocabulary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VocabularyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}