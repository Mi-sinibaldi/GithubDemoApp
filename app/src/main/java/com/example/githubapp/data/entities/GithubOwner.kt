package com.example.githubapp.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubOwner(
    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarURL: String,

    @SerializedName("type")
    val typeUser: String
): Parcelable