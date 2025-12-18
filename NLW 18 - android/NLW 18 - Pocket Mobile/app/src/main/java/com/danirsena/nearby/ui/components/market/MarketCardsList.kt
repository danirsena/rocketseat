package com.danirsena.nearby.ui.components.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danirsena.nearby.data.fakeData.fakeMarket
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun MarketCardsList(
    modifier: Modifier = Modifier,
    marketCards: List<Market>,
    onMarketClick: (Market) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Explore os locais mais parto de você",
                style = Typography.bodyLarge
            )
        }
        items(items = marketCards, key = { it.id }) { market ->
            MarketCard(
                modifier = Modifier.fillMaxWidth(),
                market = market,
                onMarketClick = {
                    onMarketClick(market)
                }
            )
        }
    }
}

@Preview
@Composable
private fun MarketCardsListPreview() {

    MarketCardsList(
        marketCards = fakeMarket,
        onMarketClick = {}
    )
}