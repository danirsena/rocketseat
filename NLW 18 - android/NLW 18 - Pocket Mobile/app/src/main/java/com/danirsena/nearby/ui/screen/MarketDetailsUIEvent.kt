package com.danirsena.nearby.ui.screen

sealed class MarketDetailsUIEvent {

    data class onFetchCoupon(val qrCodeContent: String) : MarketDetailsUIEvent()
    data class onFetchRules(val marketId: String) : MarketDetailsUIEvent()
    data object onResetCoupon : MarketDetailsUIEvent()
}