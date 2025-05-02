package com.example.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostsResponse(
    @SerialName("posts") val posts: List<Post>,
    @SerialName("pagination") val pagination: Pagination
)

@Serializable
data class Post(
    @SerialName("slug") val slug: String,
    @SerialName("title") val title: String,
    @SerialName("bodyCharacterCount") val bodyCharacterCount: Int,
    @SerialName("visibility") val visibility: String,
    @SerialName("tags") val tags: List<String>,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("updatedAt") val updatedAt: String
)

@Serializable
data class Pagination(
    @SerialName("currentPage") val currentPage: Int,
    @SerialName("nextPage") val nextPage: Int?,
    @SerialName("prevPage") val prevPage: Int?,
    @SerialName("perPage") val perPage: Int,
    @SerialName("sort") val sort: String,
    @SerialName("direction") val direction: String
)
