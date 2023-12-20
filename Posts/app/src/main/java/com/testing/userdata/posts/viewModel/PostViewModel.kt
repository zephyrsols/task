package com.testing.userdata.posts.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testing.userdata.posts.database.model.PostEntity
import com.testing.userdata.posts.database.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val allPosts: LiveData<List<PostEntity>> = repository.getAllPosts()

    fun fetchDataAndSaveToDatabase() {
        viewModelScope.launch {
            repository.fetchDataAndSaveToDatabase()
        }
    }
}
