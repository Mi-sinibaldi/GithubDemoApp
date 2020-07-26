package com.example.githubapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubapp.data.entities.GithubItem
import com.example.githubapp.data.entities.GithubPullResponse
import com.example.githubapp.data.entities.GithubResponse

@Database(
    entities = [GithubItem::class, GithubPullResponse::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun githubDao(): GithubDao
    abstract fun githubPullDao(): GithubPullDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "mydatabase")
                .fallbackToDestructiveMigration()
                .build()
    }

}