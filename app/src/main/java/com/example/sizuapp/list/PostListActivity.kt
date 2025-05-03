package com.example.sizuapp.list

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.sizuapp.ui.ArticleListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PostListActivity : ComponentActivity() {

    private val viewModel: PostListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleListScreen(viewModel = viewModel)
        }

        CoroutineScope(Dispatchers.IO).launch {
            getPosts()
        }
    }

    private suspend fun getPosts() {
        viewModel.fetchPost()
        // debug用
        Log.d("PostListActivity", "getPosts: ${viewModel.uiState.value}")
    }
}
