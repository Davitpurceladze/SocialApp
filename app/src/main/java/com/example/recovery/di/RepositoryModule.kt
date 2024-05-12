package com.example.recovery.di

import com.example.recovery.data.common.HandleResponse
import com.example.recovery.data.repository.StoryRepositoryImpl
import com.example.recovery.data.service.story.StoryService
import com.example.recovery.domain.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideStoryRepository(
        handleResponse: HandleResponse,
        storyService: StoryService
    ) : StoryRepository {
        return StoryRepositoryImpl(
            handleResponse = handleResponse,
            storyService = storyService
        )
    }
}