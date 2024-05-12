package com.example.recovery.presentation.event.home

sealed class HomeEvent {
    data object GetStories : HomeEvent()
}