package com.example.android.marsphotos.overview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.Details_NewsArticle_Activity


import com.example.android.marsphotos.databinding.NewsGridViewItemBinding


import com.example.android.marsphotos.network.NewsPhoto

class NewsGridAdapter : ListAdapter<NewsPhoto,
        NewsGridAdapter.NewsPhotoViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<NewsPhoto>() {
        override fun areItemsTheSame(oldItem: NewsPhoto, newItem: NewsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsPhoto, newItem: NewsPhoto): Boolean {
            return oldItem == newItem
        }
    }
    class NewsPhotoViewHolder(private var binding:
                              NewsGridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(NewsPhoto: NewsPhoto) {
            binding.photo = NewsPhoto
            binding.executePendingBindings()


        }


        init {
            itemView.setOnClickListener {
                val article = binding.photo
                val intent = Intent(itemView.context, Details_NewsArticle_Activity::class.java).apply {
                    putExtra("id", article?.id)
                    putExtra("title", article?.title)
                    putExtra("article_intro", article?.article_intro)
                    putExtra("article_text", article?.article_text)
                    putExtra("article_image", article?.article_image)
                    putExtra("daysAgo",article?.daysAgo)

                    // add more extras as needed
                }
                itemView.context.startActivity(intent)
            }
        }



    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsGridAdapter.NewsPhotoViewHolder {
        return NewsPhotoViewHolder(
            NewsGridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsGridAdapter.NewsPhotoViewHolder, position: Int) {
        val newsPhoto = getItem(position)
        holder.bind(newsPhoto)


    }
}