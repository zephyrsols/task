package com.testing.userdata.posts.database.repository

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import com.testing.userdata.posts.database.dao.PostDao
import com.testing.userdata.posts.database.model.PostEntity
import com.testing.userdata.posts.retrofit.ApiService

class PostRepository(
    private val context: Context,
    private val postDao: PostDao,
    private val apiService: ApiService
) {

    suspend fun fetchDataAndSaveToDatabase() {
        if (isNetworkConnected(context)) {
            // Fetch data from the API and update the Room database
            val posts = apiService.getPosts()
            postDao.insertAll(posts)
        }
    }

    fun getAllPosts(): LiveData<List<PostEntity>> {
        return postDao.getAllPosts()
    }

    private fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
