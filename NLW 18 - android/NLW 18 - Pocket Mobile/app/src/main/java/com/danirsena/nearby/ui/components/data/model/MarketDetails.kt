package com.danirsena.nearby.ui.components.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MarketDetails(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val rules: List<String>,
    val cupons: Int,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val imageUrl: String
)