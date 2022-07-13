package com.example.android.momo_assignment.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.android.momo_assignment.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    
    lateinit var binding: FragmentDetailBinding
    
    private val args: DetailFragmentArgs by navArgs()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        
        setView()
        
        return binding.root
    }
    
    private fun setView(){
        
        binding.fragmentDetailName.text = args.animal.name
        binding.fragmentDetailNameContent.text = args.animal.A_Name_En
        binding.fragmentDetailBehaviorContent.text = args.animal.A_Behavior
        binding.fragmentDetailFeatureContent.text = args.animal.A_Feature
    
        val url = args.animal.A_Pic01_URL
        val uri = url.toUri().buildUpon().scheme("https").build()
    
        Glide.with(requireContext()).load(uri).centerCrop().into(binding.fragmentDetailImage)
        
    }
}