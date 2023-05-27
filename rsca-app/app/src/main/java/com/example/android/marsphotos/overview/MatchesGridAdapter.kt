package com.example.android.marsphotos.overview

import java.text.SimpleDateFormat
import java.util.Date
import android.content.Intent
import android.graphics.Color
import android.service.autofill.FieldClassification.Match
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.Details_NewsArticle_Activity
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.MatchesGridViewItemBinding
import com.example.android.marsphotos.databinding.NewsGridViewItemBinding


import com.example.android.marsphotos.network.MatchPhoto
import java.util.*


class MatchesGridAdapter : ListAdapter<MatchPhoto,
        MatchesGridAdapter.MatchPhotoViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<MatchPhoto>() {
        override fun areItemsTheSame(oldItem: MatchPhoto, newItem: MatchPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MatchPhoto, newItem: MatchPhoto): Boolean {
            return oldItem == newItem
        }
    }
    class MatchPhotoViewHolder(private var binding:
                               MatchesGridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(MatchPhoto: MatchPhoto) {
            binding.photo = MatchPhoto


            binding.executePendingBindings()



        }






    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchesGridAdapter.MatchPhotoViewHolder {
        return MatchesGridAdapter.MatchPhotoViewHolder(
            MatchesGridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: MatchesGridAdapter.MatchPhotoViewHolder, position: Int) {
        val matchPhoto = getItem(position)
        holder.bind(matchPhoto)



    }
}