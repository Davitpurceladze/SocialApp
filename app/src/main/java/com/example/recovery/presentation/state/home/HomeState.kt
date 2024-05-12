package com.example.recovery.presentation.state.home

import com.example.recovery.presentation.model.story.Story

data class HomeState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val data : List<Story>? = null
)