package com.example.android.momo_assignment.logic.model

sealed class NetworkResult<out R> {
    
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Fail(val error: String) : NetworkResult<Nothing>()
    data class Error(val exception: Exception) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
    
    override fun toString(): String {
        return when (this){
            is Success<*> -> "Success[result=$data]"
            is Fail -> "Fail[error=$error]"
            is Error -> "Error[exception=${exception.message}]"
            Loading -> "Loading"
        }
    }
}