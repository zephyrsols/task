package com.testing.userdata.posts.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testing.userdata.posts.database.adapter.PostAdapter
import com.testing.userdata.posts.viewModel.PostViewModel
import com.testing.userdata.posts.viewModel.PostViewModelFactory
import com.testing.userdata.posts.R

class MainActivity : AppCompatActivity() {

    //variables
    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModelFactory: PostViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModelFactory = PostViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
        adapter = PostAdapter()
        recyclerView.adapter = adapter
        viewModel.allPosts.observe(this, Observer { posts ->
            adapter.submitList(posts)
        })
        viewModel.fetchDataAndSaveToDatabase()

    }


}