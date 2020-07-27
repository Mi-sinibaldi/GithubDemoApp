package com.example.githubapp.ui.githubpull

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.data.entities.GithubItem
import com.example.githubapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.github_pull_fragment.pull_progress_bar
import kotlinx.android.synthetic.main.github_pull_fragment.view.*

@AndroidEntryPoint
class GithubPullFragment : Fragment(), GithubPullAdapter.ItemListener {

    private val viewModel: GithubPullViewModel by viewModels()
    private lateinit var adapter: GithubPullAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.github_pull_fragment, container, false)
        arguments?.getParcelable<GithubItem>("githubItem")?.let { viewModel.start(it) }
        setupRecyclerView(view)
        setupObservers(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        adapter = GithubPullAdapter(this)
        view.pull_rv.layoutManager = LinearLayoutManager(activity)
        view.pull_rv.adapter = adapter
    }


    private fun setupObservers(view: View) {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            when (it.status) {

                Resource.Status.SUCCESS -> {
                    pull_progress_bar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    pull_progress_bar.visibility = View.VISIBLE
            }
        })

    }

    override fun onClickedItem(itemId: Int) {

    }
}
