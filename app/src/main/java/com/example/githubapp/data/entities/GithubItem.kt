package com.example.githubapp.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubitem")
data class GithubItem(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("full_name")
    val fullName: String,

    @Embedded
    @SerializedName("owner")
    val owner: GithubOwner,

    @SerializedName("description")
    val description: String,

    @SerializedName("forks_count")
    val forksCount: Int,

    @SerializedName("stargazers_count")
    val stargazersCount: Int
)