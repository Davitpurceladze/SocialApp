package com.example.recovery.domain.usecase.story

import com.example.recovery.domain.repository.StoryRepository
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(
    private val storyRepository: StoryRepository
) {
    suspend operator fun invoke() = storyRepository.getStories()
}