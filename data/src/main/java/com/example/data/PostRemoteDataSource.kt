package com.example.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private val client = HttpClient(OkHttp) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            isLenient = true
        })
    }
}

suspend fun fetchPosts(): Result<PostsResponse> {
    val url = "https://sizu.me/api/v1/posts"

    return try {
        val response: PostsResponse = client.get(url) {
            contentType(ContentType.Application.Json)
            header("Authorization", "Bearer ${BuildConfig.API_KEY}")
        }.body()
        Result.success(response)
    } catch (e: Exception) {
        println("Error fetching posts: ${e.message}")
        Result.failure(e)
    } finally {
        client.close()
    }
}