package com.example.githubapp.data.repository

import com.example.githubapp.data.remote.GithubRemoteDataSource
import com.example.githubapp.utils.performGetOperation
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
) {

    fun getGithubItem() = performGetOperation(
        networkCall = { remoteDataSource.getGithubItens() }
    )
}