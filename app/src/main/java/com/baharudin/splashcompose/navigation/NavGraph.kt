package com.baharudin.splashcompose.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baharudin.splashcompose.screen.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navHostController = navController)
        }
        composable(route = Screen.Home.route){
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}