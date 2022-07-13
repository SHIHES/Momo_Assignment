package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.building.BuildingResult
import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.model.animal.AnimalResult

interface DataSource {
    
    suspend fun getAllBuildingInformation(): DataResult<BuildingResult>
    
    suspend fun getAnimalInfo(): DataResult<AnimalResult>
    
}