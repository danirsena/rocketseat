package com.danirsena.nearby.ui.screen.Welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danirsena.nearby.R
import com.danirsena.nearby.ui.theme.RedBase
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun WelcomeTips(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    @DrawableRes iconRes: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconRes),
            contentDescription = "Icone",
            tint = RedBase
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = Typography.headlineSmall
            )
            Text(
                text = subtitle,
                style = Typography.bodyLarge
            )
        }
    }

}

@Composable
fun WelcomeContent(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Veja como funciona ",
            style = Typography.bodyLarge.copy(fontSize = 20.sp)
        )
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Encontre estabelecimentos perto de você",
            subtitle = "Veja os parceiros mais próximos e encontre o que mais gosta",
            iconRes = R.drawable.ic_map_pin
        )
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Ative o cupom com o QR Code",
            subtitle = "Scaneie o código do estabelecimento",
            iconRes = R.drawable.ic_qrcode
        )
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Pronto! Agora os cupons estão ativos",
            subtitle = "Aproveite para fazer compras e desfrutar de descontos!",
            iconRes = R.drawable.ic_ticket
        )
    }
}