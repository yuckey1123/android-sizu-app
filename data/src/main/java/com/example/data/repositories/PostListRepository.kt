package com.example.data.repositories

import android.util.Log
import com.example.data.PostsResponse
import com.example.data.fetchPosts

class PostListRepository {

    suspend fun getPosts(): Result<PostsResponse> {
        val result = fetchPosts()
        Log.d("PostListRepository", "getPosts: $result")
        return result
    }
}

// debug用
suspend fun main() {
    val result = fetchPosts()
    println(result)
}
