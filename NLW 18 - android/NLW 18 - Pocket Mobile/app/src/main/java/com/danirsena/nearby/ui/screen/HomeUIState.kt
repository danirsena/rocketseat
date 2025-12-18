package com.danirsena.nearby.ui.screen

import com.danirsena.nearby.ui.components.data.model.Category
import com.danirsena.nearby.ui.components.data.model.Market
import com.google.android.gms.maps.model.LatLng

data class HomeUIState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)