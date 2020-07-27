package com.example.githubapp.data.remote

import com.example.githubapp.data.entities.GithubPullResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubPullService {

    @GET("repos/{name}/{repositoryName}/pulls")
    suspend fun getGithubPUlls(@Path("name") fullName: String,@Path("repositoryName") repositoryName: String): Response<List<GithubPullResponse>>
}