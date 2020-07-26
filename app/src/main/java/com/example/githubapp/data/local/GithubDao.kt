package com.example.githubapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubapp.data.entities.GithubItem

@Dao
interface GithubDao {

    @Query("SELECT * FROM githubitem")
    fun getAllRepositories() : LiveData<List<GithubItem>>

    @Query("SELECT * FROM githubitem WHERE id = :id")
    fun getRepository(id: Int): LiveData<GithubItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(githubItems: List<GithubItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(githubItem: GithubItem)


}