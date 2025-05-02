package com.example.sizuapp.list

import androidx.lifecycle.ViewModel
import com.example.data.repositories.PostListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val repository: PostListRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<List<PostListUiState>>(emptyList())
    val uiState: StateFlow<List<PostListUiState>> = _uiState.asStateFlow()

    suspend fun fetchPost() {
        val posts = repository.getPosts()
        if (posts.isSuccess) {
            _uiState.update {
                posts.getOrNull()?.posts?.map { post ->
                    PostListUiState(
                        title = post.title,
                        date = post.createdAt
                    )
                } ?: emptyList()
            }
        }
    }
}