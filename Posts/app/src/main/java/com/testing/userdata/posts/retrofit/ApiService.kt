package com.testing.userdata.posts.retrofit

import com.testing.userdata.posts.database.model.PostEntity
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostEntity>
}
