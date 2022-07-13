package com.example.android.momo_assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.util.CurrentFragmentType

class MainViewModel(
    private val repository: DataSource
) : ViewModel() {
    
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()
    
}