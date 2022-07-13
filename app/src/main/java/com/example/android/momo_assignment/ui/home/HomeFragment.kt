package com.example.android.momo_assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.momo_assignment.databinding.FragmentHomeBinding
import com.example.android.momo_assignment.ext.getVmFactory
import com.example.android.momo_assignment.util.Logger

class HomeFragment : Fragment() {
    
    lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        
        val recyclerView = binding.buildingRv
        val adapter = BuildingAdapter(
            BuildingAdapter.OnClickListener{
            
            }
        )
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        
        viewModel.buildingResult.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it.result.results)
            }
        }
        
        
        
        return binding.root
    }
}