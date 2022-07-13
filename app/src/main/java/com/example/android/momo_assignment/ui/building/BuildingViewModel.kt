package com.example.android.momo_assignment.ui.building

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.model.animal.Animal
import com.example.android.momo_assignment.logic.model.animal.AnimalResult
import com.example.android.momo_assignment.logic.model.building.Building
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.util.Util
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class BuildingViewModel(
    private val repository: DataSource,
    private val building: Building
) : ViewModel() {
    
    private val coroutineScope = viewModelScope
    
    private val _error = MutableLiveData<String>()
    
    val error : LiveData<String>
        get() = _error
    
    private val _animalResult = MutableLiveData<AnimalResult>()
    
    val animalResult: LiveData<AnimalResult>
        get() = _animalResult
    
    private val _filterAnimalResult = MutableLiveData<List<Animal>>()
    
    val filterAnimalResult: LiveData<List<Animal>>
        get() =  _filterAnimalResult
    
    init {
        getAnimalData()
    }
    
    private fun getAnimalData(){
        
        coroutineScope.launch {
            
            val result = repository.getAnimalInfo()
            
            _animalResult.value = when (result) {
                
                is DataResult.Success -> {
                    _error.value = null
                    result.data
                }
                is DataResult.Fail -> {
                    _error.value = result.error
                    null
                }
                is DataResult.Error -> {
                    _error.value = result.exception.toString()
                    null
                }
                else -> {
                    _error.value = Util.getString(R.string.unexpected_error)
                    null
                }
            }
            
            filterAnimalData()
        }
    }
    
    private fun filterAnimalData(){
        _filterAnimalResult.value = _animalResult.value?.result?.results?.filter {
            it.A_Location == building.e_name || building.e_name.contains(it.A_Location)
        }
    }
    
    
    
    
    
}