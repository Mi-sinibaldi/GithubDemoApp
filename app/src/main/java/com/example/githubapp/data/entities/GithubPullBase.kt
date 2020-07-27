package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName

data class GithubPullBase (
    @SerializedName("label")
    val label : String,
    @SerializedName("repo")
    val repo : GithubPullRepo

)