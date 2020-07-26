package com.example.githubapp.data.repository

import com.example.githubapp.data.local.GithubDao
import com.example.githubapp.data.remote.GithubRemoteDataSource
import com.example.githubapp.utils.performGetOperation
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource,
    private val localDataSource: GithubDao
) {

    fun getGithubItem() = performGetOperation(
        databaseQuery = { localDataSource.getAllRepositories() },
        networkCall = { remoteDataSource.getGithubItens() },
        saveCallResult = { localDataSource.insertAll(it.items) }
    )
}