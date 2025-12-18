package com.danirsena.nearby.ui.components.data.model.enum

import androidx.annotation.DrawableRes
import com.danirsena.nearby.R

enum class EnumCategoryFilter(
    val description: String,
    @get:DrawableRes
    val icon: Int
) {
    ALIMENTACAO("Alimentação", R.drawable.ic_tools_kitchen_2),
    COMPRAS("Compras", R.drawable.ic_shopping_bag),
    HOSPEDAGEM("Hospedagem", R.drawable.ic_bed),
    SUPERMERCADO("Supermercado", R.drawable.ic_shopping_cart),
    ENTRETENIMENTO("Entretenimento", R.drawable.ic_movie),
    FARMACIA("Farmácia", R.drawable.ic_first_aid_kit),
    COMBUSTIVEL("Combustível", R.drawable.ic_gas_station),
    PADARIA("Padaria", R.drawable.ic_bakery),
    CINEMA("Cinema", R.drawable.ic_movie);

    companion object {

        fun fromDescription(description: String): EnumCategoryFilter? {
            return entries.find { it.description == description }
        }
    }
}