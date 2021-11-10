package com.example.navigationcomponentapp


import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController : NavController

    private lateinit var listner : NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupBottomNavMenu(navController)
        NavigationUI.setupActionBarWithNavController(this,navController)





    }
    private fun setupActionBar(navController: NavController,
                               appBarConfig : AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }


    override fun onSupportNavigateUp(): Boolean {
       // return NavigationUI.navigateUp(navController,null)
        val navController2 =findNavController(R.id.my_nav_host_fragment)
        return navController2.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  item.onNavDestinationSelected(findNavController(R.id.my_nav_host_fragment))
                || super.onOptionsItemSelected(item)
    }
    private fun setupNavigationMenu(navController: NavController) {
        val sideNavView = findViewById<NavigationView>(R.id.navigationWithAction)
        sideNavView?.setupWithNavController(navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.buttomNav)
        bottomNav?.setupWithNavController(navController)
    }
}