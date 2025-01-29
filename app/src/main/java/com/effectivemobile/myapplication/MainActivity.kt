package com.effectivemobile.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.effectivemobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.tab_container) as NavHostFragment
        navController = navHostFragment.navController.apply {
            binding?.navBar?.setupWithNavController(this)
        }
    }
}