package com.danirsena.nearby.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.danirsena.nearby.R
import com.danirsena.nearby.ui.theme.GreenLight
import kotlinx.coroutines.delay

@Composable
fun BeginScreen(modifier: Modifier = Modifier, onNavigationToWelcome: () -> Unit) {

    LaunchedEffect(key1 = Unit) {
        delay(timeMillis = 3000)
        onNavigationToWelcome()
    }

    Box(modifier = Modifier
        .background(GreenLight)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.img_logo_logo_logo_text),
            contentDescription = "Imagem do app"
        )

        Image(
            modifier = Modifier.align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription = "Imagem do mapa"
        )
    }
}

@Preview
@Composable
private fun BeginScreenPreview() {
    BeginScreen(onNavigationToWelcome = {})
}