package com.baharudin.splashcompose.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.window.SplashScreen
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.baharudin.splashcompose.navigation.Screen
import com.baharudin.splashcompose.ui.theme.Purple700
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
){
    var startAnimation by remember{ mutableStateOf(false)}
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navHostController.popBackStack()
        navHostController.navigate(Screen.Home.route)
    }
    SplashView(alpha = alphaAnimation.value)

}

@Composable
fun SplashView(alpha : Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Purple700),
        contentAlignment = Alignment.Center
    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.Email,
            contentDescription = "splash",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun SplashPrev(){
    SplashView(alpha = 1f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashBackground(){
    SplashView(alpha = 1f)
}