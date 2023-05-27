package com.example.android.marsphotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.android.marsphotos.network.NewsApi
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomescreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = NewsApi.retrofitService.getPhotos().data[0]
                val title = response.title
                val imageUrl = response.article_image
                val publication_date = response.daysAgo



                withContext(Dispatchers.Main) {
                   // findViewById<TextView>(R.id.title_textview).text = title
                    //val imageView =findViewById<ImageView>(R.id.article_image_imageview)

                }
                // Do something with the response
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
                    val intent = Intent(this@HomescreenActivity, MainActivity::class.java)
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