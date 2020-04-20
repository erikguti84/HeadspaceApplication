package com.example.headspaceapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.headspaceapplication.R
import com.example.headspaceapplication.adapter.PicsumAdapter
import com.example.headspaceapplication.databinding.FragmentListBinding
import com.example.headspaceapplication.model.PicsumResponse
import com.example.headspaceapplication.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : Fragment() {

    private val vm by navGraphViewModels<MyViewModel>(R.id.list_fragment) { viewModelFactory }
    private lateinit var binding: FragmentListBinding
    private lateinit var picsumAdapter: PicsumAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentListBinding.inflate(inflater, container, false).apply {
        picsumAdapter = PicsumAdapter()
        linearLayoutManager = LinearLayoutManager(context)
        rvPicsum.apply {
            layoutManager = linearLayoutManager
            adapter = picsumAdapter
        }
    }.also { binding = it }.root

    override fun onStart() {
        super.onStart()
        setupObserver()
        setupListener()
    }

    private fun setupObserver(){
        vm.picsumResponse
            .observe(viewLifecycleOwner) { loadPictures(it) }
    }

    private fun setupListener(){
        btn_submit.setOnClickListener {
            if(et_page.text != null){
                vm.fetchPictures(Integer.parseInt(et_page.text.toString()))
            }
        }
    }

    private fun loadPictures(list: List<PicsumResponse>) {
        picsumAdapter.submitList(list)
    }

}
