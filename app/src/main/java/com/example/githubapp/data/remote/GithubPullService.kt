package com.example.githubapp.data.remote

import com.example.githubapp.data.entities.GithubPullResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubPullService {

    @GET("repos/CyC2018/CS-Notes/pulls")
    suspend fun getGithubPUlls(): Response<List<GithubPullResponse>>
}