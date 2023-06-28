package com.othmanelkourd.moviesbook.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.othmanelkourd.moviesbook.navigation.Navigation
import com.othmanelkourd.moviesbook.navigation.Screen
import com.othmanelkourd.moviesbook.navigation.currentRoute
import com.othmanelkourd.moviesbook.navigation.navigationTitle
import com.othmanelkourd.moviesbook.ui.component.appbar.AppBarWithBackButton

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            if(currentRoute(navController) != Screen.Home.route){
                AppBarWithBackButton(navigationTitle(navController)) {
                    navController.popBackStack()
                }
            }
        }) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Navigation(navController, Modifier.padding(it))
        }
    }
}