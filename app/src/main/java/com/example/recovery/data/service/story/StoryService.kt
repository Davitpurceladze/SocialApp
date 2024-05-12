package com.example.recovery.data.service.story

import com.example.recovery.data.model.story.StoryDto
import com.example.recovery.domain.model.GetStory
import retrofit2.Response
import retrofit2.http.GET

interface StoryService {

    @GET("v3/9fb3035a-7be4-4a71-b7e9-deb83fff04c2")
    suspend fun getStories(): Response<List<StoryDto>>
}