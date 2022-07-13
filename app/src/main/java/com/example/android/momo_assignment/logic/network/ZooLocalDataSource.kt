package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.DataResult
import com.example.android.momo_assignment.logic.model.animal.AnimalResult
import com.example.android.momo_assignment.logic.model.building.BuildingResult
import com.example.android.momo_assignment.util.Logger
import com.example.android.momo_assignment.util.Util
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonParseException

object ZooLocalDataSource : DataSource {
    
    override suspend fun getAllBuildingInformation(): DataResult<BuildingResult> {
        TODO("Not yet implemented")
    }
    
    override suspend fun getAnimalInfo(): DataResult<AnimalResult> {
    
        return try {
            val jsonFileString = Util.getJsonDataFromAsset("animalInfo.json")
            Logger.d("$jsonFileString")
        
            val gson = Gson()
        
            val obj = gson.fromJson(jsonFileString, AnimalResult::class.java)
            Logger.d("$obj")
        
            DataResult.Success(obj)
        
        } catch (e: JsonIOException) {
            e.printStackTrace()
        
            DataResult.Error(e)
        
        } catch (e: JsonParseException) {
            e.printStackTrace()
            DataResult.Error(e)
        }
    }
}