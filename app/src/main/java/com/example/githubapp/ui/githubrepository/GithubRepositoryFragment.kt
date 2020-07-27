package com.example.githubapp.ui.githubrepository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.githubapp.R
import com.example.githubapp.data.entities.GithubItem
import com.example.githubapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.github_repository_fragment.*
import kotlinx.android.synthetic.main.github_repository_fragment.view.*

@AndroidEntryPoint
class GithubRepositoryFragment : Fragment(), GithubRepositoryAdapter.ItemListener {

    private val viewModel: GithubRepositoryViewModel by viewModels()
    private lateinit var adapter: GithubRepositoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.github_repository_fragment, container, false)
        setupRecyclerView(view)
        setupObservers()
        return view
    }

    private fun setupRecyclerView(view: View) {
        adapter = GithubRepositoryAdapter(this)
        view.characters_rv.layoutManager = LinearLayoutManager(activity)
        view.characters_rv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.githubItens.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progress_bar.visibility = View.GONE
                    if (!it.data?.items.isNullOrEmpty()) adapter.setItems(ArrayList(it.data!!.items))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    progress_bar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedItem(githubItem: GithubItem) {
        findNavController().navigate(
            R.id.action_charactersFragment_to_characterDetailFragment,
            bundleOf("githubItem" to githubItem)

        )
    }
}
