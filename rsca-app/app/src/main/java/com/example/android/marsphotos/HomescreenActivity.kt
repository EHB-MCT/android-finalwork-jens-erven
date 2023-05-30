package com.example.android.marsphotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.android.marsphotos.network.MatchesApi
import com.example.android.marsphotos.network.NewsApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import android.widget.LinearLayout

class HomescreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        val cardView = findViewById<CardView>(R.id.card_view)
        val imageView = findViewById<ImageView>(R.id.article_image_imageview_homescreen)
        val more_matches_link = findViewById<LinearLayout>(R.id.more_matches_link)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = NewsApi.retrofitService.getPhotos().data
                val latestNewsPhoto = response.firstOrNull()

                // now also find the last match
                val responseMatches = MatchesApi.retrofitService.getPhotos().data
                val latestMatchPhoto = responseMatches.lastOrNull()

                withContext(Dispatchers.Main) {
                    if (latestNewsPhoto != null && latestMatchPhoto != null) {

                        // data for the news
                        val title = latestNewsPhoto.title
                        val intro = latestNewsPhoto.article_intro
                        val text = latestNewsPhoto.article_text
                        val image = latestNewsPhoto.preview_image
                        val daysAgo = latestNewsPhoto.daysAgo


                        // Load and display the image using Picasso
                        Picasso.get().load(image).into(imageView)
                        findViewById<TextView>(R.id.title_textview).text = title
                        findViewById<TextView>(R.id.publication_date_textview).text = daysAgo

                        // data for the matches
                        val opponent_logo = latestMatchPhoto.opponent_logo
                        val league = latestMatchPhoto.league_name
                        val score= latestMatchPhoto.score_results
                        val scheduled_date = latestMatchPhoto.scheduled_date






                        findViewById<TextView>(R.id.date_text).text= scheduled_date
                        findViewById<TextView>(R.id.league_text).text = league
                        findViewById<TextView>(R.id.score_text).text = score

                        val opponentView = findViewById<ImageView>(R.id.opponent_team_icon)
                        Picasso.get().load(opponent_logo).into(opponentView)


                        cardView.setOnClickListener {
                            val intentNews = Intent(this@HomescreenActivity, Details_NewsArticle_Activity::class.java).apply {
                                putExtra("title", title)
                                putExtra("article_intro", intro)
                                putExtra("article_text", text)
                                putExtra("article_image", image)
                                putExtra("daysAgo", daysAgo)
                            }
                            startActivity(intentNews)
                        }

                        more_matches_link.setOnClickListener{
                            val intentMatches = Intent(this@HomescreenActivity, MatchesActivity::class.java)
                            startActivity(intentMatches)
                        }
                    }
                }
            } catch (e: Exception) {
                // Handle network errors here
            }
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.menu_home

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // Handle Home button click
                    true
                }
                R.id.menu_team -> {
                    val intent = Intent(this@HomescreenActivity, TeamActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_news -> {
                    val intent = Intent(this@HomescreenActivity, NewsActivity::class.java)
                    startActivity(intent)
                    // Handle Notifications button click
                    true
                }
                R.id.menu_matches -> {
                    val intent = Intent(this@HomescreenActivity, MatchesActivity::class.java)
                    startActivity(intent)
                    // Handle Profile button click
                    true
                }
                else -> false
            }
        }
    }
}