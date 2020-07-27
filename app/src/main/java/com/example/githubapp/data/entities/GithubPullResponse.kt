package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName


data class GithubPullResponse(

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,


    @SerializedName("user")
    val user: GithubPullUser,


    @SerializedName("base")
    val base: GithubPullBase,

    val id: Int
)
