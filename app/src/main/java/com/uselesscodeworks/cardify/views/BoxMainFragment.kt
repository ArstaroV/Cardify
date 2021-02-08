package com.uselesscodeworks.cardify.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
//import androidx.navigation.Navigation
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uselesscodeworks.cardify.viewmodels.BoxMainViewModel
import com.uselesscodeworks.cardify.R
import com.uselesscodeworks.cardify.data.CardifyDatabase
import com.uselesscodeworks.cardify.data.BoxRepository
import com.uselesscodeworks.cardify.models.Box
import com.uselesscodeworks.cardify.views.adapters.BoxItemAdapter
import com.uselesscodeworks.cardify.views.adapters.RecyclerViewClickListener
import kotlinx.android.synthetic.main.box_dialog.*
import kotlinx.android.synthetic.main.box_main_fragment.*

class BoxMainFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var viewModel: BoxMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.box_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //viewModel = ViewModelProvider(this).get(BoxMainViewModel::class.java)
        val local = CardifyDatabase.getInstance(requireContext()).boxDao()
        val repo = BoxRepository(local)
        viewModel = BoxMainViewModel(repo)
        viewModel.boxes.observe(viewLifecycleOwner, Observer {boxes -> box_list.also{
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(false)
            it.adapter = BoxItemAdapter(boxes, this)}})

    }

    override fun OnItemClick(view: View, box: Box) {
        Toast.makeText(requireContext(), box.name, Toast.LENGTH_SHORT).show()
        CardifyDatabase.getInstance(requireContext()).selectedBoxId = box.id
        val action = BoxMainFragmentDirections.actionBoxMainFragmentToVocabularyFragment()
        findNavController().navigate(action)
    }

    override fun OnItemHold(view: View, box: Box) {
        Toast.makeText(requireContext(), "HOLD WORKS", Toast.LENGTH_SHORT).show()
    }
}