/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * MainActivity sets the content view activity_main, a fragment container that contains
 * overviewFragment.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
            bottomNavigation.selectedItemId = R.id.menu_team


            bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_home -> {
                        val intent = Intent(this@MainActivity, HomescreenActivity::class.java)
                        startActivity(intent)
                        // Handle Home button click
                        true
                    }
                    R.id.menu_team -> {


                        true
                    }
                    R.id.menu_news -> {
                        val intent = Intent(this@MainActivity, NewsActivity::class.java)
                        startActivity(intent)
                        // Handle Notifications button click
                        true
                    }
                    R.id.menu_matches -> {
                        val intent = Intent(this@MainActivity, MatchesActivity::class.java)
                        startActivity(intent)
                        // Handle Profile button click
                        true
                    }
                    else -> false
                }
            }


        }


    }
