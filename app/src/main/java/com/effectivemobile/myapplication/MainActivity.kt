package com.effectivemobile.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.effectivemobile.core.navigator.Navigation
import com.effectivemobile.feature_main.MainFragmentDirections
import com.effectivemobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigation {

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

    override fun goToDetailsFromMain(id: String) {
        navController?.navigate(MainFragmentDirections.actionMainFragmentToVacancyDetailsFragment(id))
    }

    override fun goToDetailsFromFavorites(id: String) {
        navController?.navigate(R.id.action_favoritesFragment_to_vacancyDetailsFragment)

    }
}