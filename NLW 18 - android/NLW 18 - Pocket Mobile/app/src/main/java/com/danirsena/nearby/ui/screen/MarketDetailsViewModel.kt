package com.danirsena.nearby.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danirsena.nearby.core.network.RemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {

    val _uiState = MutableStateFlow(MarketDetailsUIState())
    val uiState: StateFlow<MarketDetailsUIState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUIEvent) {
        when (event) {
            is MarketDetailsUIEvent.onFetchCoupon -> fetchCoupon(qrCodeContent = event.qrCodeContent)
            is MarketDetailsUIEvent.onFetchRules -> fetchRules(marketId = event.marketId)
            is MarketDetailsUIEvent.onResetCoupon -> resetCoupon()
        }
    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {

            RemoteDataSource.generateDiscountCoupon(qrCodeContent).fold(
                onSuccess = { coupon ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            coupon = coupon.coupon
                        )
                    }
                },
                onFailure = { _ ->
                    _uiState.update { currentUiState ->
                        currentUiState.copy(
                            coupon = ""
                        )
                    }
                }
            )

        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            RemoteDataSource.getMarketDetails(marketId)
                .onSuccess { marketDetails ->
                _uiState.update { currentState ->
                    currentState.copy(
                        rules = marketDetails.rules
                    )
                }
            }
            .onFailure { _ ->
                _uiState.update { currentUiState ->
                    currentUiState.copy(
                        rules = emptyList()
                    )
                }
            }

        }
    }

    private fun resetCoupon() {
        _uiState.update { currentState ->
            currentState.copy(
                coupon = null
            )
        }
    }
}