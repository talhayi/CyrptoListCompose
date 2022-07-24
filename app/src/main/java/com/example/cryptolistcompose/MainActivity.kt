package com.example.cryptolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.cryptolistcompose.ui.theme.CryptoListComposeTheme
import com.example.cryptolistcompose.view.CyrptoDetailScreen
import com.example.cryptolistcompose.view.CyrptoListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoListComposeTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "crypto_list_screen") {
                    composable("crypto_list_screen") {
                        CyrptoListScreen(navController = navController)

                    }

                    composable("crypto_detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cyrptoId") {
                            type = NavType.StringType
                        },
                        navArgument("cyrptoPrice") {
                            type = NavType.StringType
                        }
                    )) {
                        val cryptoId = remember {
                            it.arguments?.getString("cyrptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cyrptoPrice")
                        }
                        CyrptoDetailScreen(
                            id = cryptoId ?: "",
                            price = cryptoPrice ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
