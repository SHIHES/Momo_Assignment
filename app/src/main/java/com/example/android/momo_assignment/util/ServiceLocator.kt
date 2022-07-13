package com.example.android.momo_assignment.util

import androidx.annotation.VisibleForTesting
import com.example.android.momo_assignment.logic.network.DefaultRepository
import com.example.android.momo_assignment.logic.network.ZooDataSource
import com.example.android.momo_assignment.logic.network.ZooRemoteDataSource

object ServiceLocator {
    
    @Volatile
    var repository:ZooDataSource? = null
    @VisibleForTesting set
    
    fun provideTasksRepository(): ZooDataSource {
        synchronized(this) {
            return repository
                ?: createRepository()
        }
    }
    
    private fun createRepository(): ZooDataSource {
        return DefaultRepository(
            ZooRemoteDataSource
        )
    }
}