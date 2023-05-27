package com.example.android.marsphotos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)




        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.menu_news

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    val intent = Intent(this@NewsActivity, HomescreenActivity::class.java)
                    startActivity(intent)
                    // Handle Home button click
                    true
                }
                R.id.menu_team -> {

                    val intent = Intent(this@NewsActivity, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_news -> {

                    // Handle Notifications button click
                    true
                }
                R.id.menu_matches -> {
                    val intent = Intent(this@NewsActivity, MatchesActivity::class.java)
                    startActivity(intent)
                    // Handle Profile button click
                    true
                }
                else -> false
            }
        }





    }

}