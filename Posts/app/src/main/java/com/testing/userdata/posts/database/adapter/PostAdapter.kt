package com.testing.userdata.posts.database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.testing.userdata.posts.R
import com.testing.userdata.posts.database.model.PostEntity

class PostAdapter : ListAdapter<PostEntity, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val bodyTextView: TextView = itemView.findViewById(R.id.body)

        fun bind(post: PostEntity) {
            titleTextView.text = post.title
            bodyTextView.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.recycer_items, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<PostEntity>() {
    override fun areItemsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostEntity, newItem: PostEntity): Boolean {
        return oldItem == newItem
    }
}
