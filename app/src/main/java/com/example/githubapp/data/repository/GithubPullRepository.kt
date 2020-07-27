package com.example.githubapp.data.repository

import com.example.githubapp.data.remote.GithubRemoteDataSource
import com.example.githubapp.utils.performGetOperation
import javax.inject.Inject

class GithubPullRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
) {
    fun getGithubPull(name: String, repositoryName:String) = performGetOperation(
        networkCall = { remoteDataSource.getGithubPulls(name,repositoryName) }
    )
}