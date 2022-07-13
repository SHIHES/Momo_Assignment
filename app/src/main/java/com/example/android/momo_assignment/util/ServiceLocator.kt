package com.example.android.momo_assignment.util

import androidx.annotation.VisibleForTesting
import com.example.android.momo_assignment.logic.network.DefaultRepository
import com.example.android.momo_assignment.logic.network.DataSource
import com.example.android.momo_assignment.logic.network.ZooLocalDataSource
import com.example.android.momo_assignment.logic.network.ZooRemoteDataSource

object ServiceLocator {
    
    @Volatile
    var repository: DataSource? = null
    @VisibleForTesting set
    
    fun provideTasksRepository(): DataSource {
        synchronized(this) {
            return repository
                ?: createRepository()
        }
    }
    
    private fun createRepository(): DataSource {
        return DefaultRepository(
            ZooRemoteDataSource,
            ZooLocalDataSource
        )
    }
}