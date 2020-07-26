package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName

data class GithubPullUser(

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("login")
    val login: String
)
