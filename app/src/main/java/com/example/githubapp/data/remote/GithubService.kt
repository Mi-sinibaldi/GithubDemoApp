package com.example.githubapp.data.remote

import com.example.githubapp.data.entities.GithubResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1 ")
    suspend fun getGithubItens(): Response<GithubResponse>


}