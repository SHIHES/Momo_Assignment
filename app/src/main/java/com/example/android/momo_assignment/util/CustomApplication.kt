package com.example.android.momo_assignment.util

import android.app.Application
import kotlin.properties.Delegates

class CustomApplication : Application() {
    
    companion object {
        var instance: CustomApplication by Delegates.notNull()
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}