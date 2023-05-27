package com.example.android.marsphotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

class Details_NewsArticle_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news_article)





        val articleTitleTextView = findViewById<TextView>(R.id.article_title_textview)
        val articleIntroTextView = findViewById<TextView>(R.id.article_intro_textview)
        val articleTextTextView = findViewById<TextView>(R.id.article_text_textview)
        val articlePublicationDateTextView = findViewById<TextView>(R.id.date_textview)



        val title = intent.getStringExtra("title")
        val intro = intent.getStringExtra("article_intro")
        val text = intent.getStringExtra("article_text")
        val image = intent.getStringExtra("article_image")
        val daysAgo = intent.getStringExtra("daysAgo")

        articleTitleTextView.text = "$title"
        articleIntroTextView.text = "${intro ?: ""}"
        articleTextTextView.text = "${text ?: ""}"
        articlePublicationDateTextView.text="${daysAgo ?: ""}"



        Glide.with(this)
            .load(image)
            .into(findViewById(R.id.article_image_imageview))

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle ="$title"
    }
}