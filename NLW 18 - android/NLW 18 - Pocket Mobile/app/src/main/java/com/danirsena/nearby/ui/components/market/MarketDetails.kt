package com.danirsena.nearby.ui.components.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danirsena.nearby.R
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.theme.Gray400
import com.danirsena.nearby.ui.theme.Gray500
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun MarketDetails(
    modifier: Modifier = Modifier,
    market: Market
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Informações",
            style = Typography.headlineSmall,
            color = Gray400
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_ticket),
                    contentDescription = "Icon dos cupons",
                    tint = Gray500
                )
                Text(
                    text = "${market.cupons} cupons disponíveis",
                    style = Typography.labelMedium.copy(fontSize = 12.sp),
                    color = Gray500
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    contentDescription = "Icon do endereço",
                    tint = Gray500
                )
                Text(
                    text = market.address,
                    style = Typography.labelMedium.copy(fontSize = 12.sp),
                    color = Gray500
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_phone),
                    contentDescription = "Icon do telefone",
                    tint = Gray500
                )
                Text(
                    text = market.phone,
                    style = Typography.labelMedium.copy(fontSize = 12.sp),
                    color = Gray500
                )
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsPreview() {
    MarketDetails(
        modifier = Modifier.fillMaxWidth(),
        market = Market(
            id = "1",
            name = "Barraca do seu Tião",
            categoryId = "1",
            description = "Lanchonete perto do centro que tem os melhores pastéis e um doce - e gelado - caldo de cana",
            cupons = 3,
            //rules = emptyList(),
            address = "Av. Adam, 260",
            latitude = 0.0,
            longitude = 0.0,
            phone = "(11) 99999-9999",
            imageUrl = "https://example.com/image.jpg"
        )
    )

}