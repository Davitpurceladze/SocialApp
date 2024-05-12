package com.example.recovery.presentation.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recovery.databinding.StoryLayoutBinding
import com.example.recovery.presentation.model.story.Story

class StoryRecyclerAdapter :
    ListAdapter<Story, StoryRecyclerAdapter.StoryViewHolder>(StoryDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(
            StoryLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind()
    }

    inner class StoryViewHolder(private val binding: StoryLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            private lateinit var item: Story

        fun bind() {
            item = currentList[adapterPosition]
            with(binding) {
                title.text = item.title
            }

        }

    }


    class StoryDiffUtil : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem == newItem
        }
    }
}