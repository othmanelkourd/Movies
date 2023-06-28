package com.othmanelkourd.moviesbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.othmanelkourd.moviesbook.ui.screens.main.MainScreen
import com.othmanelkourd.moviesbook.ui.theme.MoviesBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesBookTheme {
                MainScreen()
            }
        }
    }
}


