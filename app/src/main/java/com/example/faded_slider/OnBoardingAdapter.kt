package com.example.faded_slider

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.faded_slider.databinding.ItemObBinding


class OnBoardingAdapter: ListAdapter<OnBoardingModel,OnBoardingAdapter.ItemObViewHolder>(ObDiffUtil()) {

    inner class ItemObViewHolder(private val binding: ItemObBinding) : ViewHolder(binding.root) {
        @SuppressLint("ClickableViewAccessibility")
        fun onBind(item: OnBoardingModel){
            setTextContent(item)
            setIvContent(item)
        }

        private fun setIvContent(item: OnBoardingModel) {
            binding.ivPreview.setImageResource(item.ivResource)
        }

        private fun setTextContent(item: OnBoardingModel) {
            binding.apply {
                tvTitle.text = item.title
                tvDescription.text = item.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemObViewHolder {
        return ItemObViewHolder(
            ItemObBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemObViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}

class ObDiffUtil: ItemCallback<OnBoardingModel>(){
    override fun areItemsTheSame(oldItem: OnBoardingModel, newItem: OnBoardingModel): Boolean {
       return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(oldItem: OnBoardingModel, newItem: OnBoardingModel): Boolean {
        return oldItem.index == newItem.index
    }
}

