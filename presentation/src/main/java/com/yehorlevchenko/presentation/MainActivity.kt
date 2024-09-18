package com.yehorlevchenko.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import com.yehorlevchenko.presentation.ui.theme.BurgerRestaurantMenuTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yehorlevchenko.presentation.ui.screen.details.burger.BurgerDetailsScreen
import com.yehorlevchenko.presentation.ui.screen.details.drink.DrinkDetailsScreen
import com.yehorlevchenko.presentation.ui.screen.overview.RestaurantOverviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BurgerRestaurantMenuTheme {
                Scaffold { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        NavHost()
                    }
                }
            }
        }
    }

    @Composable
    fun NavHost() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "overview") {
            composable("overview") {
                RestaurantOverviewScreen(navController = navController)
            }
            composable(
                route = "details/burger/{burgerName}",
                arguments = listOf(navArgument("burgerName") { type = NavType.StringType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("burgerName")?.let {
                    BurgerDetailsScreen(burgerName = it, navController = navController)
                }
            }
            composable(
                route = "details/drink/{drinkName}",
                arguments = listOf(navArgument("drinkName") { type = NavType.StringType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("drinkName")?.let {
                    DrinkDetailsScreen(drinkName = it, navController = navController)
                }
            }
        }
    }
}