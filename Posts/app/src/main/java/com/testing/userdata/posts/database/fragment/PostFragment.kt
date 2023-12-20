package com.testing.userdata.posts.database.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testing.userdata.posts.R
import com.testing.userdata.posts.database.adapter.PostAdapter
import com.testing.userdata.posts.viewModel.PostViewModel

class PostFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels()
    private lateinit var adapter: PostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PostAdapter()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Observe the LiveData and update the adapter when the data changes
        viewModel.allPosts.observe(viewLifecycleOwner, Observer { posts ->
            adapter.submitList(posts)
        })

        // Trigger data fetching when the fragment is created
        viewModel.fetchDataAndSaveToDatabase()
    }
}
