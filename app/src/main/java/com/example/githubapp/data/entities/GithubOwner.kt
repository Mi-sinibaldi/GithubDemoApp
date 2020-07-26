package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName

data class GithubOwner(
    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarURL: String,

    @SerializedName("type")
    val typeUser: String
)