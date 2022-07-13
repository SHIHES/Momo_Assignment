package com.example.android.momo_assignment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.logic.model.building.Building
import com.example.android.momo_assignment.logic.model.building.BuildingResult
import com.example.android.momo_assignment.logic.model.LoadApiStatus
import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.util.Logger
import com.example.android.momo_assignment.util.Util
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: DataSource
) : ViewModel() {
    
    private val coroutineScope = viewModelScope
    
    private val _status = MutableLiveData<LoadApiStatus>()
    
    val status: LiveData<LoadApiStatus>
        get() = _status
    
    private val _error = MutableLiveData<String?>()
    
    val error: LiveData<String?>
        get() = _error
    
    private val _buildingData = MutableLiveData<BuildingResult>()
    
    val buildingResult: LiveData<BuildingResult>
        get() = _buildingData
    
    private val _navigateToDetail = MutableLiveData<Building>()
    
    val navigateToDetail: LiveData<Building>
        get() = _navigateToDetail
    
    
    init {
        getBuildingData()
    }
    
    
    private fun getBuildingData() {
        
        coroutineScope.launch {
            _status.value = LoadApiStatus.LOADING

            val result = repository.getAllBuildingInformation()
            
            _buildingData.value = when(result) {
                is DataResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    result.data
                    
                }
                is DataResult.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                is DataResult.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                    null
                }
                else -> {
                    _error.value =  Util.getString(R.string.unexpected_error)
                    _status.value = LoadApiStatus.ERROR
                    null
                }
            }
        }
    }
    
    fun navigateToDetail(building: Building){
        _navigateToDetail.value = building
    }
    
    fun navigateEnd(){
        _navigateToDetail.value = null
    }
}