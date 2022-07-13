package com.example.android.momo_assignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.momo_assignment.MainViewModel
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.ui.building.BuildingViewModel
import com.example.android.momo_assignment.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: DataSource
) : ViewModelProvider.NewInstanceFactory() {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(repository)
                
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(repository)
                
                else ->
                    throw  IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        
    } as T
}