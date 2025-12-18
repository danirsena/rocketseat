package com.danirsena.nearby.ui.screen.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danirsena.nearby.R
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun WelcomeHeader(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_logo_logo_icon),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Bem-vindo(a) ao Pocket",
            style = Typography.headlineLarge.copy(fontSize = 24.sp)
        )
        Text(
            text = "Tenha cupons de desconto em estabelecimentos perto de você",
            style = Typography.bodyLarge
        )
    }
}