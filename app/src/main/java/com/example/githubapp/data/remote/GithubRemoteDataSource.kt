package com.example.githubapp.data.remote

import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val githubService: GithubService,
    private val githubPullService: GithubPullService
) : BaseDataSource() {

    suspend fun getGithubItens() = getResult { githubService.getGithubItens() }
    suspend fun getGithubPulls(name: String,repositoryName: String) = getResult { githubPullService.getGithubPUlls(name,repositoryName) }
}