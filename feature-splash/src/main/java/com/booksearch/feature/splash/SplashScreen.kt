package com.booksearch.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreenBody() {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.background)
    )
    val progress by animateLottieCompositionAsState(composition)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            contentScale = ContentScale.FillBounds
        )
    }
}