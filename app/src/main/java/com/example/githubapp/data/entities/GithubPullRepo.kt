package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName

data class GithubPullRepo(
    @SerializedName("fullname")
    val fullname : String,
    @SerializedName("name")
    val name : String
)