package com.danirsena.nearby.ui.components.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danirsena.nearby.data.fakeData.fakeCategoriesList
import com.danirsena.nearby.ui.components.data.model.Category
import kotlin.collections.firstOrNull

@Composable
fun CategoriesFilterList(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onSelectedCategoryChanged: (Category) -> Unit
) {
    var selectedCategoryID by remember {
        mutableStateOf(categories.firstOrNull()?.id ?: "")
    }

    // ✅ Correção: usa o valor diretamente no LaunchedEffect
    LaunchedEffect(selectedCategoryID) {
        val selectedCategoryOrNull = categories.find { it.id == selectedCategoryID }
        selectedCategoryOrNull?.let { onSelectedCategoryChanged(it) }
    }

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = categories, key = { it.id }) { category ->
            NearbyCategoriesFilter(
                category = category,
                isSelected = category.id == selectedCategoryID,
                onClick = { isSelected ->
                    if (isSelected) selectedCategoryID = category.id
                }
            )
        }
    }
}

@Preview
@Composable
private fun CategoriesFilterListPreview(
) {
    CategoriesFilterList(
        modifier = Modifier.fillMaxWidth(),
        categories = fakeCategoriesList,
        onSelectedCategoryChanged = {}
    )
}