package com.danirsena.nearby.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.danirsena.nearby.data.fakeData.fakeCategoriesList
import com.danirsena.nearby.data.fakeData.fakeMarket
import com.danirsena.nearby.ui.components.categories.CategoriesFilterList
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.components.market.MarketCardsList
import com.danirsena.nearby.ui.theme.Gray100
import com.google.maps.android.compose.GoogleMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onEvent: (HomeUIEvent) -> Unit,
    onNavigationToMarketDetails: (Market) -> Unit
) {

    val mapState = rememberBottomSheetScaffoldState()
    var isMapStateOpened by remember { mutableStateOf(true) }

    //pega as dimensões da tela
    val configuration = LocalConfiguration.current

    LaunchedEffect(true) {
        onEvent(HomeUIEvent.OnFetchCategories)
    }

    if (isMapStateOpened) {
        BottomSheetScaffold(
            modifier = modifier,
            scaffoldState = mapState,
            sheetContainerColor = Gray100,
            sheetPeekHeight = configuration.screenHeightDp.dp * 0.5f /*(Cobre 50% da tela)*/,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetContent = {
                if (!uiState.markets.isNullOrEmpty())
                    MarketCardsList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        marketCards = uiState.markets,
                        onMarketClick = { selectedMarket ->
                            onNavigationToMarketDetails(selectedMarket)
                        }
                    )
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    GoogleMap(modifier = Modifier.fillMaxSize())
                }

                if (!uiState.categories.isNullOrEmpty())
                    CategoriesFilterList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        categories = uiState.categories,
                        onSelectedCategoryChanged = { selectedCategory ->
                            onEvent(HomeUIEvent.OnFetchMarketsByCategory(selectedCategory.id))
                        })
            }
        )
    }
}

@Preview
@Composable
private fun HomeMapPreview() {
    HomeScreen(onNavigationToMarketDetails = {}, uiState = HomeUIState(), onEvent = {})
}