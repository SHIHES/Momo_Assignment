package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.logic.model.BuildingResult
import com.example.android.momo_assignment.logic.model.NetworkResult
import com.example.android.momo_assignment.util.Logger
import com.example.android.momo_assignment.util.Util

object ZooRemoteDataSource : ZooDataSource {
    
    override suspend fun getAllBuildingInformation(): NetworkResult<BuildingResult> {
        
//        if (Util.isInternetConnected()){
//            return NetworkResult.Fail(Util.getString(R.string.internet_not_connected))
//        }
        
        return try {
            val callback = BuildingApi.retrofitServiceBuilding.getAllBuildingInformation()
            Logger.d("[${this::class.simpleName}] getAllBuildingInformation callback=${callback}")
            NetworkResult.Success(callback)
        } catch (e: Exception) {
            Logger.d("[${this::class.simpleName}] getAllBuildingInformation exception=${e.message}")
            NetworkResult.Error(e)
        }
    }
}