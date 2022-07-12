package com.example.android.momo_assignment.ext

import androidx.fragment.app.Fragment
import com.example.android.momo_assignment.factory.ViewModelFactory
import com.example.android.momo_assignment.util.CustomApplication

fun Fragment.getVmFactory(): ViewModelFactory {
    
    val repository = (requireContext().applicationContext as CustomApplication).zooRepository
    return ViewModelFactory(repository)
}