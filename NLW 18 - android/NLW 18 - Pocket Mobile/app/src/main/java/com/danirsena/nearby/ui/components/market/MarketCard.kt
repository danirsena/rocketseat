package com.danirsena.nearby.ui.components.market

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.danirsena.nearby.R
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.theme.Gray100
import com.danirsena.nearby.ui.theme.Gray200
import com.danirsena.nearby.ui.theme.Gray400
import com.danirsena.nearby.ui.theme.Gray500
import com.danirsena.nearby.ui.theme.GreenBase
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun MarketCard(
    modifier: Modifier,
    market: Market,
    onMarketClick: (Market) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp)),
        onClick = {
            onMarketClick(market)
        }
    )
    {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = market.imageUrl,
                contentDescription = "Imagem do estabelecimento",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth(0.25f)
                    .height(IntrinsicSize.Min)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
            )
            Column {
                Text(
                    text = market.name,
                    style = Typography.headlineSmall.copy(fontSize = 16.sp)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = market.description,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500
                )
                Spacer(Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_ticket),
                        contentDescription = "Cupons disponíveis",
                        modifier = Modifier.size(24.dp),
                        tint = if (market.cupons > 0) GreenBase else Gray500
                    )
                    Text(
                        text = "${market.cupons} cupons disponíveis",
                        style = Typography.bodyMedium.copy(fontSize = 12.sp),
                        color = Gray400
                    )
                }
            }
        }
    }

}

@Composable
@Preview
private fun MarketCardPreview() {
    MarketCard(
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
        ),
        onMarketClick = {}
    )
}