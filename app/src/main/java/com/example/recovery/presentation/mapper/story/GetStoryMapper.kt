package com.example.recovery.presentation.mapper.story

import com.example.recovery.domain.model.GetStory
import com.example.recovery.presentation.model.story.Story

fun GetStory.toPresenter() = Story(
    id = id, cover = cover, title = title
)