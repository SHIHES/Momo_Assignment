package com.example.android.momo_assignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.momo_assignment.logic.network.ZooDataSource
import com.example.android.momo_assignment.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: ZooDataSource
) : ViewModelProvider.NewInstanceFactory() {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(repository)
                
                else ->
                    throw  IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        
    } as T
}