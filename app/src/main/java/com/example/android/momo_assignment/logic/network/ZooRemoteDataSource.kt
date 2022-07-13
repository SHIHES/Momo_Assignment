package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.building.BuildingResult
import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.model.animal.AnimalResult
import com.example.android.momo_assignment.util.Logger

object ZooRemoteDataSource : DataSource {
    
    override suspend fun getAllBuildingInformation(): DataResult<BuildingResult> {
        
//        if (Util.isInternetConnected()){
//            return NetworkResult.Fail(Util.getString(R.string.internet_not_connected))
//        }
        
        return try {
            val callback = BuildingApi.retrofitServiceBuilding.getAllBuildingInformation()
            Logger.d("[${this::class.simpleName}] getAllBuildingInformation callback=${callback}")
            DataResult.Success(callback)
        } catch (e: Exception) {
            Logger.d("[${this::class.simpleName}] getAllBuildingInformation exception=${e.message}")
            DataResult.Error(e)
        }
    }
    
    override suspend fun getAnimalInfo(): DataResult<AnimalResult> {
        TODO("Not yet implemented")
    }
}