package com.danirsena.nearby.ui.screen

sealed class HomeUIEvent {

    data object OnFetchCategories : HomeUIEvent()
    data class OnFetchMarketsByCategory(val categoryId: String) : HomeUIEvent()
}