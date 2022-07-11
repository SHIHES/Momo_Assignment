package com.example.android.momo_assignment.util

import android.content.Context
import android.net.ConnectivityManager

object Util {
    
    fun isInternetConnected() : Boolean {
        val cm = CustomApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
    
    fun getString(resourceId: Int): String {
        return CustomApplication.instance.getString(resourceId)
    }
}