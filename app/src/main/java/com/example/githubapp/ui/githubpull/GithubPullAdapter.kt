package com.example.githubapp.ui.githubpull

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.githubapp.R
import com.example.githubapp.data.entities.GithubPullResponse
import kotlinx.android.synthetic.main.item_github_pull_adapter.view.*

class GithubPullAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<GithubPullViewHolder>() {

    interface ItemListener {
        fun onClickedItem(itemId: Int)
    }

    private val items = ArrayList<GithubPullResponse>()

    fun setItems(items: ArrayList<GithubPullResponse>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubPullViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_github_pull_adapter, parent, false)
        return GithubPullViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GithubPullViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class GithubPullViewHolder(
    private val view: View,
    private val listener: GithubPullAdapter.ItemListener
) : RecyclerView.ViewHolder(view),
    View.OnClickListener {

    private lateinit var githubPull: GithubPullResponse

    init {
        view.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: GithubPullResponse) {
        this.githubPull = item
        view.textViewTitlePull.text = item.title
        view.textViewBodyPullRequest.text = item.body
        view.textViewUsernamePull.text = item.user.login
        Glide.with(view)
            .load(item.user.avatarUrl)
            .transform(CircleCrop())
            .into(view.imageViewPersonPull)
    }

    override fun onClick(v: View?) {
        listener.onClickedItem(githubPull.id)
    }
}