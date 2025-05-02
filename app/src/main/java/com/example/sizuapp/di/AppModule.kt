package com.example.sizuapp.di

import com.example.data.repositories.PostListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun providePostListRepository(): PostListRepository {
        return PostListRepository()
    }
}