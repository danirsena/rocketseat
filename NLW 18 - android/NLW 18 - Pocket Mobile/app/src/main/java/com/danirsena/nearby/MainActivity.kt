package com.danirsena.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.danirsena.nearby.ui.components.data.model.Market
import com.danirsena.nearby.ui.screen.BeginScreen
import com.danirsena.nearby.ui.screen.HomeScreen
import com.danirsena.nearby.ui.screen.HomeViewModel
import com.danirsena.nearby.ui.screen.MarketDetailsScreen
import com.danirsena.nearby.ui.screen.WelcomeScreen
import com.danirsena.nearby.ui.screen.route.Begin
import com.danirsena.nearby.ui.screen.route.Home
import com.danirsena.nearby.ui.screen.route.Welcome
import com.danirsena.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            NearbyTheme {

                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController,
                    startDestination = Begin
                ) {
                    composable<Begin> {
                        BeginScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigationToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }
                    composable<Welcome> {
                        WelcomeScreen(
                            onNavigationToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigationToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            },
                            uiState = uiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                    composable<Market> {

                        val selectedMarket = it.toRoute<Market>()
                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}