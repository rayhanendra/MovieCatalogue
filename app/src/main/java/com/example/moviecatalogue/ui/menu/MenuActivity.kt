package com.example.moviecatalogue.ui.menu

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ActivityMenuBinding
import com.example.moviecatalogue.ui.menu.ui.favorited.FavoritedFragment
import com.example.moviecatalogue.ui.menu.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_menu.view.*

class MenuActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var binding: ActivityMenuBinding
    private val homeFragment: Fragment = HomeFragment()
    private val favoritedFragment: Fragment = FavoritedFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_favorited
        ).build()

//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        supportActionBar?.title = "Movie Catalogue"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.elevation = 0f

//        commitFragment(homeFragment)
//        binding.navView.setOnNavigationItemSelectedListener {
//            clearFragmentStack()
//            when(it.itemId) {
//                navigation_home -> {
//                    commitFragment(homeFragment)
//                }
//                navigation_favorited -> {
//                    commitFragment(favoritedFragment)
//                }
//            }
//            true
//        }

    }

//    private fun commitFragment(fragment: Fragment){
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.navigation_home, fragment)
//            .commit()
//    }
//
//    private fun clearFragmentStack(){
//        val fm = this.supportFragmentManager
//        for ( i in 0..fm.backStackEntryCount){
//            fm.popBackStack()
//        }
//    }
//
//
//    override fun onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed()
//            return
//        }
//        this.doubleBackToExitPressedOnce = true
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
//
//        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
//    }
}