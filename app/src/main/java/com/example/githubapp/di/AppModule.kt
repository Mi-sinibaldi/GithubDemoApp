package com.example.githubapp.di

import android.content.Context
import com.example.githubapp.data.remote.GithubPullService
import com.example.githubapp.data.remote.GithubRemoteDataSource
import com.example.githubapp.data.remote.GithubService
import com.example.githubapp.data.repository.GithubPullRepository
import com.example.githubapp.data.repository.GithubRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideGithubItemService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @Provides
    fun provideGithubPullService(retrofit: Retrofit): GithubPullService =
        retrofit.create(GithubPullService::class.java)

    @Singleton
    @Provides
    fun provideGithubRemoteDataSource(
        githubService: GithubService,
        githubPullService: GithubPullService
    ) = GithubRemoteDataSource(githubService, githubPullService)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: GithubRemoteDataSource) =
        GithubRepository(remoteDataSource)

    @Singleton
    @Provides
    fun providePullRepository(
        remoteDataSource: GithubRemoteDataSource
    ) =
        GithubPullRepository(remoteDataSource)
}