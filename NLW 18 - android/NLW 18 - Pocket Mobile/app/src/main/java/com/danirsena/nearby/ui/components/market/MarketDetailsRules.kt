package com.danirsena.nearby.ui.components.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danirsena.nearby.ui.components.data.model.Rule
import com.danirsena.nearby.ui.theme.Gray400
import com.danirsena.nearby.ui.theme.Gray500
import com.danirsena.nearby.ui.theme.Typography

@Composable
fun MarketDetailRules(modifier: Modifier = Modifier, rules: List<Rule>) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Regulamento", style = Typography.headlineSmall, color = Gray400)

        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = rules.joinToString("\n", transform = { " > ${it.description}" }),
            style = Typography.labelMedium,
            color = Gray500,
            lineHeight = 24.sp
        )
    }

}

@Preview
@Composable
private fun MarketDetailRulesPreview() {

    MarketDetailRules(
        modifier = Modifier.fillMaxWidth(),
        rules = listOf(
            Rule(
                id = "1",
                description = "Regulamento 1",
                marketId = "13"
            ),
            Rule(
                id = "2",
                description = "Regulamento 2",
                marketId = "13"
            ),
            Rule(
                id = "3",
                description = "Regulamento 3",
                marketId = "13"
            )
        )
    )
}