package com.ali.bookhub

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)       //setting up hamburger icon
        actionBarDrawerToggle.syncState() //syncing opening closing state

        //Adding onclick listeners on Menu Items in Navigation Drawer
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, DashboardFragment())
                        .addToBackStack("Dashboard")
                        .commit()

                    drawerLayout.closeDrawers()
                }
                R.id.favourites ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, FavouritesFragment())
                        .addToBackStack("Favourites")
                        .commit()

                    drawerLayout.closeDrawers()
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()

                    drawerLayout.closeDrawers()
                }
                R.id.aboutApp ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, AboutAppFragment())
                        .addToBackStack("About App")
                        .commit()

                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }
fun setUpToolbar(){
    setSupportActionBar(toolbar)
    supportActionBar?.title = "Toolbar Title"
    supportActionBar?.setHomeButtonEnabled(true)        //added back button in toolbar
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)    //helps opening drawer from left side
        }
        return super.onOptionsItemSelected(item)
    }
}