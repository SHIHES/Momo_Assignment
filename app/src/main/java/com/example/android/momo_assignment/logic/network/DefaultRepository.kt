package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.BuildingResult
import com.example.android.momo_assignment.logic.model.NetworkResult
import com.example.android.momo_assignment.logic.model.Result

class DefaultRepository(
    private val remoteDataSource: ZooDataSource
) : ZooDataSource{
    
    override suspend fun getAllBuildingInformation(): NetworkResult<BuildingResult> {
        return remoteDataSource.getAllBuildingInformation()
    }
    
    
}