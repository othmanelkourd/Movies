package com.othmanelkourd.moviesbook.navigation

import androidx.annotation.StringRes
import com.othmanelkourd.moviesbook.R

sealed class Screen(
    val route: String,
    @StringRes val title: Int = R.string.app_title,
    val screenName: String = "",
    val screenPath: String = ""
) {
    object Home : Screen("home_screen")
    object MovieDetail :
        Screen("movie_detail_screen", screenName = "movie", screenPath = "/{movie}")

}