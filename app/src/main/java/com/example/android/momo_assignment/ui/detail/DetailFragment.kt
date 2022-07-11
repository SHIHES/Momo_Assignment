package com.example.android.momo_assignment.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.momo_assignment.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    
    lateinit var binding: FragmentDetailBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}