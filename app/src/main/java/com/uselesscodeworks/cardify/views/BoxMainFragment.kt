package com.uselesscodeworks.cardify.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.viewmodels.BoxMainViewModel
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.views.adapters.BoxItemAdapter
import com.uselesscodeworks.cardify.views.listeners.RecyclerViewClickListener
import kotlinx.android.synthetic.main.box_main_fragment.*

class BoxMainFragment : Fragment(),
    RecyclerViewClickListener, AddBoxDialog.AddBoxDialogListener {

    private lateinit var viewModel: BoxMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.box_main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val local = CardifyDatabase.getInstance(requireContext()).boxDao()
        val repo = BoxRepository(local)
        viewModel = BoxMainViewModel(repo)
        viewModel.boxes.observe(viewLifecycleOwner, Observer {boxes -> box_list.also{
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(false)
            it.adapter = BoxItemAdapter(boxes, this)}})

        fab.setOnClickListener {
            AddBoxDialog(this)
                .show(childFragmentManager, "Add Box")
        }
    }

    override fun onItemClick(view: View, box: Box) {
        CardifyDatabase.getInstance(requireContext()).selectedBoxId = box.id
        val action = BoxMainFragmentDirections.actionBoxMainFragmentToVocabularyFragment()
        findNavController().navigate(action)
    }

    override fun onItemHold(view: View, box: Box) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${box.name}")
        builder.setMessage("Are you sure you want to delete ${box.name}?")
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteBox(box)
        }
        builder.setNegativeButton("No") {_,_ -> }
        builder.show()
    }

    override fun onAddBoxClick(boxName: String) {
        viewModel.addBox(Box(boxName))
    }
}