package com.example.githubapp.ui.githubpull

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.githubapp.data.entities.GithubItem
import com.example.githubapp.data.entities.GithubPullResponse
import com.example.githubapp.data.repository.GithubPullRepository
import com.example.githubapp.utils.Resource

class GithubPullViewModel @ViewModelInject constructor(
    private val repository: GithubPullRepository
) : ViewModel() {

    private val _githubItem = MutableLiveData<GithubItem>()

    private val _result = _githubItem.switchMap { gitHubItem ->
        repository.getGithubPull(gitHubItem.owner.login, gitHubItem.name)
    }

    val result: LiveData<Resource<List<GithubPullResponse>>> = _result

    fun start(githubItem: GithubItem) {
        _githubItem.value = githubItem
    }

}

