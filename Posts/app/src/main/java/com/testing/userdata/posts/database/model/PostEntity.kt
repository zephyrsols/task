package com.testing.userdata.posts.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)
