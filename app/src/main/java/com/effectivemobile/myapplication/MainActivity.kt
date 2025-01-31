package com.effectivemobile.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.effectivemobile.core.navigator.Navigation
import com.effectivemobile.core.utils.BadgeUpdater
import com.effectivemobile.feature_favorite.FavoriteFragmentDirections
import com.effectivemobile.feature_main.MainFragmentDirections
import com.effectivemobile.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigation, BadgeUpdater {

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

        updateBadge(0)
    }

    override fun goToDetailsFromMain(id: String) {
        navController?.navigate(MainFragmentDirections.actionMainFragmentToVacancyDetailsFragment(id))

    }

    override fun goToDetailsFromFavorites(id: String) {
        navController?.navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToVacancyDetailsFragment(
                id
            )
        )
    }

    override fun updateBadge(count: Int) {
        val badgeDrawable = binding?.navBar?.getOrCreateBadge(R.id.favoriteFragment)
        if (count > 0) {
            badgeDrawable?.number = count
            badgeDrawable?.isVisible = true
        } else {
            badgeDrawable?.isVisible = false
        }
    }
}