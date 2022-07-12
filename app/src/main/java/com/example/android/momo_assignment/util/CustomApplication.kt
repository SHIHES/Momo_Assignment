package com.example.android.momo_assignment.util

import android.app.Application
import com.example.android.momo_assignment.logic.network.ZooDataSource
import kotlin.properties.Delegates

class CustomApplication : Application() {
    
    val zooRepository: ZooDataSource
        get() = ServiceLocator().provideTasksRepository()
    
    companion object {
        var instance: CustomApplication by Delegates.notNull()
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}