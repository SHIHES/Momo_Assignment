package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.building.BuildingResult
import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.model.animal.AnimalResult

class DefaultRepository(
    private val remoteDataSource: DataSource,
    private val localDataSource: DataSource
) : DataSource {
    
    override suspend fun getAllBuildingInformation(): DataResult<BuildingResult> {
        return remoteDataSource.getAllBuildingInformation()
    }
    
    override suspend fun getAnimalInfo(): DataResult<AnimalResult> {
        return localDataSource.getAnimalInfo()
    }
    
    
}