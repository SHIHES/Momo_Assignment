package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.BuildingResult
import com.example.android.momo_assignment.logic.model.NetworkResult
import com.example.android.momo_assignment.logic.model.Result

interface ZooDataSource {
    
    suspend fun getAllBuildingInformation(): NetworkResult<BuildingResult>
    
}