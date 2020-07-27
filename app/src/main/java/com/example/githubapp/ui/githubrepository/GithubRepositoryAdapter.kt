package com.example.githubapp.ui.githubrepository

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.item_github_repository_adapter.view.*
import com.example.githubapp.R
import com.example.githubapp.data.entities.GithubItem

class GithubRepositoryAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<GithubRepositoryViewHolder>() {

    interface ItemListener {
        fun onClickedItem(githubItem: GithubItem)
    }

    private val items = ArrayList<GithubItem>()

    fun setItems(items: ArrayList<GithubItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_repository_adapter, parent, false)
        return GithubRepositoryViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class GithubRepositoryViewHolder(
    private val view: View,
    private val listener: GithubRepositoryAdapter.ItemListener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private lateinit var githubItem: GithubItem

    init {
        view.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: GithubItem) {
        this.githubItem = item
        view.textViewTitleRepository.text = item.name
        view.textViewDescRepository.text = item.description
        view.textViewUsernameRepository.text = item.name
        view.textViewFullNameRepository.text = item.fullName
        view.textViewQtdFork.text = item.forksCount.toString()
        view.textViewQtdStars.text = item.stargazersCount.toString()
        Glide.with(view)
            .load(item.owner.avatarURL)
            .transform(CircleCrop())
            .into(view.imageViewPersonRepository)
    }

    override fun onClick(v: View?) {
        listener.onClickedItem(githubItem)
    }
}