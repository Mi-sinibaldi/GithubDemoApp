package com.example.githubapp.data.repository

import com.example.githubapp.data.local.GithubPullDao
import com.example.githubapp.data.remote.GithubRemoteDataSource
import com.example.githubapp.utils.performGetOperation
import javax.inject.Inject

class GithubPullRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource,
    private val localDataSource: GithubPullDao
) {
    fun getGithubPull(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getAllRepositories() },
        networkCall = { remoteDataSource.getGithubPulls(id) },
        saveCallResult = { localDataSource.insertAll(it) }
    )
}