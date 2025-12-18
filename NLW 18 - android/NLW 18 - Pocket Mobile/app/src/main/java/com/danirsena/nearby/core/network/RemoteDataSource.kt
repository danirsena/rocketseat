package com.danirsena.nearby.core.network

import com.danirsena.nearby.core.network.KtorHttpClient.httpClient
import com.danirsena.nearby.ui.components.data.model.Category
import com.danirsena.nearby.ui.components.data.model.Coupon
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.components.data.model.MarketDetails
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object RemoteDataSource {

    private const val LOCAL_HOST_URL = "http://10.0.2.2:3333"

    private const val BASE_URL = LOCAL_HOST_URL

    // 1 - busca de categorias
    // 2 - busca de locais com base em categoria
    // 3 - busca de detalhes de um local
    // 4 - gerar cupom de desconto a partir da leitura do QR Code

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClient.get("$BASE_URL/categories")

        Result.success(categories.body())

    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketsByCategory(categoryId: String): Result<List<Market>> = try {
        val markets = httpClient.get("$BASE_URL/markets/category/${categoryId}")
        Result.success(markets.body())
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetails(marketId: String): Result<MarketDetails> = try {
        val market = httpClient.get("$BASE_URL/markets/${marketId}")
        Result.success(market.body())
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun generateDiscountCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClient.patch("$BASE_URL/coupons/${marketId}")
        Result.success(coupon.body())
    } catch (e: Exception) {
        Result.failure(e)
    }
}