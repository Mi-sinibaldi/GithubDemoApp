package com.example.githubapp.data.entities

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubpull")
data class GithubPullResponse(

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,

    @Embedded
    @SerializedName("user")
    val user: GithubPullUser,

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int
)
