package com.effectivemobile.core.navigator

import androidx.fragment.app.Fragment

interface Navigation {

    fun goToDetailsFromMain(id: String)

    fun goToDetailsFromFavorites(id: String)
}

fun Fragment.navigate(): Navigation {
    return requireActivity() as Navigation
}