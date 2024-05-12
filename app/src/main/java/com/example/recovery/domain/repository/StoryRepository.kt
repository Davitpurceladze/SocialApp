package com.example.recovery.domain.repository

import com.example.recovery.data.common.Resource
import com.example.recovery.domain.model.GetStory
import kotlinx.coroutines.flow.Flow

interface StoryRepository {

    suspend fun getStories(): Flow<Resource<List<GetStory>>>

}