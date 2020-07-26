package com.example.githubapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubapp.data.entities.GithubPullResponse

@Dao
interface GithubPullDao {

    @Query("SELECT * FROM githubpull")
    fun getAllRepositories(): LiveData<List<GithubPullResponse>>

    @Query("SELECT * FROM githubpull WHERE id = :id")
    fun getRepository(id: Int): LiveData<List<GithubPullResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(githubPullResponse: List<GithubPullResponse>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(githubPullResponse: GithubPullResponse)
}