package com.example.android.momo_assignment.logic.network

import com.example.android.momo_assignment.logic.model.BuildingResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://data.taipei/api/v1/dataset/"

private val client = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface BuildingApiService {
    
    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getAllBuildingInformation() : BuildingResult
}

object BuildingApi {
    val retrofitServiceBuilding: BuildingApiService by lazy { retrofit.create(BuildingApiService::class.java) }
}