package com.danirsena.nearby.ui.components.data.model

import androidx.annotation.DrawableRes
import com.danirsena.nearby.ui.components.data.model.enum.EnumCategoryFilter
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    val name: String
) {
    @get:DrawableRes
    val icon: Int?
        get() = EnumCategoryFilter.fromDescription(name)?.icon
}