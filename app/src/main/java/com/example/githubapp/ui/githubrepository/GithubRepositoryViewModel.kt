package com.example.githubapp.ui.githubrepository

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.githubapp.data.repository.GithubRepository

class GithubRepositoryViewModel @ViewModelInject constructor(
    private val repository: GithubRepository
) : ViewModel() {
    val githubItens = repository.getGithubItem()
}