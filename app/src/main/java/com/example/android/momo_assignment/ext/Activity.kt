package com.example.android.momo_assignment.ext

import android.app.Activity
import com.example.android.momo_assignment.factory.ViewModelFactory
import com.example.android.momo_assignment.util.CustomApplication

fun Activity.getVmFactory(): ViewModelFactory {
    
    val repository = (this.applicationContext as CustomApplication).zooRepository
    return ViewModelFactory(repository)
}