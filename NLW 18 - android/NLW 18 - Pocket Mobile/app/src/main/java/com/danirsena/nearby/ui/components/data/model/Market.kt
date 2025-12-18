package com.danirsena.nearby.ui.components.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Market(
    val id: String,
    val name: String,
    val categoryId: String,
    val description: String,
    val cupons: Int,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val imageUrl: String
)