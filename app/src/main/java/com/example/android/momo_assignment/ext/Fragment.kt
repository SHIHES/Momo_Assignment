package com.example.android.momo_assignment.ext

import androidx.fragment.app.Fragment
import com.example.android.momo_assignment.factory.BuildingViewModelFactory
import com.example.android.momo_assignment.factory.ViewModelFactory
import com.example.android.momo_assignment.logic.model.building.Building
import com.example.android.momo_assignment.util.CustomApplication

fun Fragment.getVmFactory(): ViewModelFactory {
    
    val repository = (requireContext().applicationContext as CustomApplication).zooRepository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(building: Building): BuildingViewModelFactory {
    
    val repository = (requireContext().applicationContext as CustomApplication).zooRepository
    return BuildingViewModelFactory(repository, building)
}