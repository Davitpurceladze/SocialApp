package com.example.recovery.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recovery.data.common.Resource
import com.example.recovery.domain.usecase.story.GetStoriesUseCase
import com.example.recovery.presentation.event.home.HomeEvent
import com.example.recovery.presentation.mapper.story.toPresenter
import com.example.recovery.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stories : GetStoriesUseCase
) : ViewModel()   {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState get() = _homeState.asStateFlow()


    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GetStories -> getStories()
        }
    }

    private fun  getStories() {
        viewModelScope.launch {
            stories.invoke().collect{
                when(it) {
                    is Resource.Error -> _homeState.update {currentState ->
                        currentState.copy(
                            errorMessage = it.errorMessage
                        )
                    }

                    is Resource.Loading -> _homeState.update { currentState ->
                        currentState.copy(
                            isLoading = it.loading
                        )
                    }

                    is Resource.Success -> _homeState.update { currentState ->
                        currentState.copy(
                            data = it.data.map {
                                it.toPresenter()
                            }
                        )
                    }
                }
           }
        }
    }



}