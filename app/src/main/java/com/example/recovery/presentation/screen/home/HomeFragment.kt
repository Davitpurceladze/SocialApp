package com.example.recovery.presentation.screen.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recovery.databinding.FragmentHomeBinding
import com.example.recovery.presentation.base.BaseFragment
import com.example.recovery.presentation.event.home.HomeEvent
import com.example.recovery.presentation.screen.home.adapter.StoryRecyclerAdapter
import com.example.recovery.presentation.model.story.Story
import com.example.recovery.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var storyRecyclerAdapter: StoryRecyclerAdapter


    override fun bind() {
        setStoryRecycler()
        viewModel.onEvent(HomeEvent.GetStories)

    }

    override fun bindViewActionsListeners() {

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.homeState.collect{
                    handleState(it)
                }
            }
        }

    }

    private fun setStoryRecycler() {
        with(binding.storyRecycler) {
            storyRecyclerAdapter = StoryRecyclerAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = storyRecyclerAdapter
        }
        storyRecyclerAdapter.submitList(storyList)
    }

    private fun handleState(state: HomeState) = with(state) {
        data?.let {
            println(it)
        }
    }


    private val storyList: List<Story> = listOf(
        Story(
            id = 1,
            title = "title1",
            cover = "Cover1"

        ),
        Story(
            id = 2,
            title = "title1",
            cover = "Cover1"

        ), Story(
            id = 3,
            title = "title1",
            cover = "Cover1"

        )
    )
}