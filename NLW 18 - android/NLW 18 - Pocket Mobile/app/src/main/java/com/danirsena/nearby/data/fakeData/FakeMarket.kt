package com.danirsena.nearby.data.fakeData

import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.components.data.model.Rule

val fakeMarket = listOf<Market>(
    Market(

        id = "1",
        name = "Barraca do seu Tião",
        categoryId = "1",
        description = "Lanchonete perto do centro que tem os melhores pastéis e um doce - e gelado - caldo de cana",
        cupons = 3,
//        rules = listOf(
//            Rule("1", "Comprar 100 reais de produtos", "1"),
//            Rule("2", "Estar fazendo aniversário", "1"),
//            Rule("3","Disponível para consumo no mercado", "1")
//        ),
        address = "Av. Adam, 260",
        latitude = 0.0,
        longitude = 0.0,
        phone = "(11) 99999-9999",
        imageUrl = "https://example.com/image.jpg"
    ),
    Market(

        id = "2",
        name = "Barraca do seu Tião",
        categoryId = "1",
        description = "Lanchonete perto do centro que tem os melhores pastéis e um doce - e gelado - caldo de cana",
        cupons = 3,
        //rules = emptyList(),
        address = "Av. Adam, 260",
        latitude = 0.0,
        longitude = 0.0,
        phone = "(11) 99999-9999",
        imageUrl = "https://example.com/image.jpg"
    )
)