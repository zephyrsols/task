package com.testing.userdata.posts.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testing.userdata.posts.database.model.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostEntity>)
}
