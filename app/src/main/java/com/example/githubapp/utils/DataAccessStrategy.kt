package com.example.githubapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.githubapp.utils.Resource.Status.*
import kotlinx.coroutines.Dispatchers

fun <T> performGetOperation(
    networkCall: suspend () -> Resource<T>
): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())

        val responseStatus = networkCall.invoke()

        if (responseStatus.status == SUCCESS) {
            emit(Resource.success(responseStatus.data!!))

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }