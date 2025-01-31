package com.effectivemobile.core.utils

import androidx.fragment.app.Fragment

interface BadgeUpdater {

    fun updateBadge(count: Int)
}

fun Fragment.updater(): BadgeUpdater {
    return requireActivity() as BadgeUpdater
}