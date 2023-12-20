package com.testing.userdata.posts.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testing.userdata.posts.database.repository.PostRepository
import com.testing.userdata.posts.retrofit.RetrofitClient
import com.testing.userdata.posts.database.AppDatabase
import com.testing.userdata.posts.retrofit.ApiService


class PostViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            val database = AppDatabase.getDatabase(application)
            val postDao = database.postDao()
            val apiService = RetrofitClient.create(ApiService::class.java)
            val repository = PostRepository(application.applicationContext, postDao, apiService)
            return PostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
