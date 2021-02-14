package com.uselesscodeworks.cardify.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.data.VocabularyRepository
import com.uselesscodeworks.cardify.models.Vocabulary
import com.uselesscodeworks.cardify.viewmodels.VocabularyViewModel
import com.uselesscodeworks.cardify.views.adapters.VocabularyItemAdapter
import com.uselesscodeworks.cardify.views.listeners.VocabularyRecyclerViewListener
import kotlinx.android.synthetic.main.vocabulary_fragment.*
import kotlinx.android.synthetic.main.vocabulary_fragment.fab

class VocabularyFragment : Fragment(),
    VocabularyRecyclerViewListener {

    private lateinit var viewModel: VocabularyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vocabulary_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val local = CardifyDatabase.getInstance(requireContext()).vocabelDao()
        val repo = VocabularyRepository(local)
        viewModel = VocabularyViewModel(repo)
        viewModel.vocabels.observe(viewLifecycleOwner, Observer {vocabels -> vocabulary_list.also{
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(false)
            it.adapter = VocabularyItemAdapter(vocabels, this)
        }})

        fab.setOnClickListener {
            viewModel.addVocabulary(Vocabulary("", "", CardifyDatabase.getInstance(requireContext()).selectedBoxId))
        }
    }

    override fun onItemHold(vocabulary: Vocabulary) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${vocabulary.sourceVocabulary} : ${vocabulary.targetVocabulary}")
        builder.setMessage("Are you sure you want to delete ${vocabulary.sourceVocabulary} : ${vocabulary.targetVocabulary}?")
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteVocabulary(vocabulary)
        }
        builder.setNegativeButton("No") {_,_ -> }
        builder.show()
    }

    override fun onLostFocus(vocabulary: Vocabulary) {
        viewModel.updateVocabulary(vocabulary)
    }
}