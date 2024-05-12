package com.example.recovery.data.mapper.story

import com.example.recovery.data.model.story.StoryDto
import com.example.recovery.domain.model.GetStory


fun StoryDto.toDomain() = GetStory(
    id = id, cover = cover, title = title
)