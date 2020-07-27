package com.example.githubapp

import com.example.githubapp.data.repository.GithubRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GithubRepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CorroutineTestRule()

    private var githubRepository: GithubRepository = mock()

    @Before
    fun before() {

    }

    @ExperimentalCoroutinesApi
    @Test
    fun validadeGetItem() =
        coroutineTestRule.testDispatcher.runBlockingTest {
            githubRepository
                .getGithubItem()
            verify(githubRepository).getGithubItem()
        }


}
