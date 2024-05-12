package com.example.recovery.data.repository

import com.example.recovery.data.common.HandleResponse
import com.example.recovery.data.common.Resource
import com.example.recovery.data.mapper.base.asResource
import com.example.recovery.data.mapper.story.toDomain
import com.example.recovery.data.service.story.StoryService
import com.example.recovery.domain.model.GetStory
import com.example.recovery.domain.repository.StoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val storyService: StoryService
) : StoryRepository {
    override suspend fun getStories(): Flow<Resource<List<GetStory>>> {
        return handleResponse.safeApiCall {
            storyService.getStories()
        }.asResource {
            it.map { storyDto ->
                storyDto.toDomain()
            }
        }
    }
}