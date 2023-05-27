package com.example.android.marsphotos

import java.text.SimpleDateFormat
import PhotoGridAdapter
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.Employee
import com.example.android.marsphotos.network.MatchPhoto

import com.example.android.marsphotos.network.NewsPhoto
import com.example.android.marsphotos.overview.MatchesGridAdapter
import com.example.android.marsphotos.overview.NewsGridAdapter
import java.util.*


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Employee>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("listNewsData")
fun bindNewsRecyclerView(recyclerView: RecyclerView,
                     data: List<NewsPhoto>?) {
    val adapter = recyclerView.adapter as NewsGridAdapter
    adapter.submitList(data)
}


@BindingAdapter("listMatchesData")
fun bindMatchesRecyclerView(recyclerView: RecyclerView,
                         data: List<MatchPhoto>?) {
    val adapter = recyclerView.adapter as MatchesGridAdapter
    adapter.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("android:textColor")
fun setTextColor(textView: TextView, colorString: String) {
    val color = Color.parseColor(colorString)
    textView.setTextColor(color)
}







