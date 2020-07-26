package com.example.githubapp.ui.githubpull

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.githubapp.data.entities.GithubPullResponse
import com.example.githubapp.data.repository.GithubPullRepository
import com.example.githubapp.utils.Resource

class GithubPullViewModel @ViewModelInject constructor(
    private val repository: GithubPullRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _result = _id.switchMap { id ->
        repository.getGithubPull(id)
    }

    val result: LiveData<Resource<List<GithubPullResponse>>> = _result

    fun start(id: Int) {
        _id.value = id
    }

}

