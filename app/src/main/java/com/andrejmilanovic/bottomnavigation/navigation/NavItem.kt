package com.andrejmilanovic.bottomnavigation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.andrejmilanovic.bottomnavigation.R

sealed class NavItem(@StringRes val title: Int, @DrawableRes val icon: Int, val navRoute: String) {
    object Home : NavItem(R.string.home, R.drawable.ic_home, Screen.Home.name)
    object Favorite : NavItem(R.string.favorite, R.drawable.ic_favorite, Screen.Favorite.name)
    object Search : NavItem(R.string.search, R.drawable.ic_search, Screen.Search.name)
    object Random : NavItem(R.string.random, R.drawable.ic_dice, Screen.Random.name)
}