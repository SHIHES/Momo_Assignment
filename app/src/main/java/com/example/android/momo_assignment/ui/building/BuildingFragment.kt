package com.example.android.momo_assignment.ui.building

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.momo_assignment.databinding.FragmentHomeBinding

class BuildingFragment : Fragment() {
    
    lateinit var binding: FragmentHomeBinding
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}