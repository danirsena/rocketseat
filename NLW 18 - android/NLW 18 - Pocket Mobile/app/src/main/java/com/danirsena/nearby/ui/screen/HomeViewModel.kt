package com.danirsena.nearby.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danirsena.nearby.core.network.RemoteDataSource
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.OnFetchCategories -> fetchCategories()
            is HomeUIEvent.OnFetchMarketsByCategory -> fetchMarketsByCategory(event.categoryId)
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                RemoteDataSource.getCategories().fold(
                    onSuccess = { categories ->
                        currentState.copy(
                            categories = categories
                        )
                    },
                    onFailure = { _ ->
                        currentState.copy(
                            categories = emptyList()
                        )
                    }
                )
            }
        }
    }

    private fun fetchMarketsByCategory(categoryId: String) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                RemoteDataSource.getMarketsByCategory(categoryId).fold(
                    onSuccess = { markets ->
                        currentState.copy(
                            markets = markets,
                            marketLocations = markets.map { market ->
                                LatLng(market.latitude, market.longitude)
                            }
                        )
                    },
                    onFailure = { _ ->
                        currentState.copy(
                            markets = emptyList(),
                            marketLocations = emptyList()
                        )
                    }
                )
            }
        }
    }
}