package com.example.githubapp.data.entities

import com.google.gson.annotations.SerializedName

data class GithubResponse(

    @SerializedName("total_count")
    val totalCount: Long,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @SerializedName("items")
    val items: List<GithubItem>
)