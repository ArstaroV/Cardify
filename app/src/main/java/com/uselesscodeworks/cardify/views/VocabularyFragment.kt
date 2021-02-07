package com.uselesscodeworks.cardify.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.data.VocabularyRepository
import com.uselesscodeworks.cardify.viewmodels.VocabularyViewModel
import com.uselesscodeworks.cardify.views.adapters.VocabularyItemAdapter
import kotlinx.android.synthetic.main.vocabulary_fragment.*

class VocabularyFragment : Fragment() {

    private lateinit var viewModel: VocabularyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vocabulary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(VocabularyViewModel::class.java)
        val local = CardifyDatabase.getInstance(requireContext()).vocabelDao()
        val repo = VocabularyRepository(local)
        viewModel = VocabularyViewModel(repo)
        viewModel.vocabels.observe(viewLifecycleOwner, Observer {vocabels -> vocabulary_list.also{
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = VocabularyItemAdapter(vocabels)
        }})
        Toast.makeText(requireContext(), CardifyDatabase.getInstance(requireContext()).selectedBoxId.toString(), Toast.LENGTH_SHORT).show()
    }

}