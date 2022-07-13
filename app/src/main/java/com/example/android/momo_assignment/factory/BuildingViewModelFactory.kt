package com.example.android.momo_assignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.momo_assignment.logic.model.building.Building
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.ui.building.BuildingViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class BuildingViewModelFactory(
    private val repository: DataSource,
    private val building: Building
) : ViewModelProvider.NewInstanceFactory() {
    
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                
                isAssignableFrom(BuildingViewModel::class.java) ->
                    BuildingViewModel(repository, building)
                
                else ->
                    throw  IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
            
        } as T
}