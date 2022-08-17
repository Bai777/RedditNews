package com.example.redditnews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditnews.databinding.RedditPostRecyclerItemBinding
import com.example.redditnews.domain.RedditPost

class MainScreenRecyclerAdapter :
    RecyclerView.Adapter<MainScreenRecyclerAdapter.MainViewHolder>() {

    private var listData: List<RedditPost> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = RedditPostRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class MainViewHolder(private val binding: RedditPostRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: RedditPost) {
            binding.apply {
                title.text = post.title
                score.text = post.score.toString()
                comments.text = post.comments.toString()
            }
        }
    }

    fun setData(data: List<RedditPost>) {
        listData = listData + data
        notifyDataSetChanged()
    }
}