package com.example.android.momo_assignment.ui.building

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.android.momo_assignment.MainActivity
import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.databinding.FragmentBuildingBinding
import com.example.android.momo_assignment.ext.getVmFactory

class BuildingFragment : Fragment() {
    
    lateinit var binding: FragmentBuildingBinding
    
    private val arg: BuildingFragmentArgs by navArgs()
    private val viewModel by viewModels <BuildingViewModel> { getVmFactory(BuildingFragmentArgs.fromBundle(requireArguments()).building) }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        
        binding = FragmentBuildingBinding.inflate(inflater, container, false)
        
        val recyclerView = binding.fragmentBuildingAnimalRv
        val adapter = AnimalAdapter(AnimalAdapter.OnClickListener{
            viewModel.navigateToDetail(it)
        })
        
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        
        setView()
        (requireActivity() as MainActivity).setupToolbarTitle(arg.building.e_name)
        
        viewModel.filterAnimalResult.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
        
        viewModel.navigateToDetail.observe(viewLifecycleOwner) {
            it?.let {
                
                findNavController().navigate(BuildingFragmentDirections.actionBuildingFragmentToDetailFragment(it))
                viewModel.navigateEnd()
            }
        }
        
        return binding.root
    }
    
    
    private fun setView() {
        binding.fragmentBuildingWhere.text = arg.building.e_category
        binding.fragmentBuildingDetailInfo.text = arg.building.e_info
        
        if (arg.building.e_memo.isEmpty() == true) {
            binding.fragmentBuildingRestDay.text =
                com.example.android.momo_assignment.util.Util.getString(
                    R.string.no_rest_day_info
                )
        } else {
            binding.fragmentBuildingRestDay.text = arg.building.e_memo
        }
        
        val url = arg.building.e_pic_url
        val uri = url.toUri().buildUpon().scheme("https").build()
        
        Glide.with(requireContext()).load(uri).centerCrop().into(binding.fragmentBuildingImage)
        
    }
    
    
}