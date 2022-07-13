package com.example.android.momo_assignment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.logic.model.BuildingResult
import com.example.android.momo_assignment.logic.model.LoadApiStatus
import com.example.android.momo_assignment.logic.model.NetworkResult
import com.example.android.momo_assignment.logic.network.ZooDataSource
import com.example.android.momo_assignment.util.Logger
import com.example.android.momo_assignment.util.Util
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ZooDataSource
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
    
    
    init {
        getBuildingData()
    }
    
    
    private fun getBuildingData() {
        
        coroutineScope.launch {
            _status.value = LoadApiStatus.LOADING

            val result = repository.getAllBuildingInformation()
            
            _buildingData.value = when(result) {
                is NetworkResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    Logger.d("result data${result.data}")
                    result.data
                    
                }
                is NetworkResult.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                    Logger.d("result error${result.error}")
                    null
                }
                is NetworkResult.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                    Logger.d("result exception${result.exception}")
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
}