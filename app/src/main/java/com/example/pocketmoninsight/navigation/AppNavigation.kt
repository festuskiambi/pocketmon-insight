package com.example.pocketmoninsight.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.PokemonFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider,
) {
    NavHost(navController = navController, startDestination = PokemonFeature.NESTED_ROUTE) {
        navigationProvider.pokemonApi.registerGraph(
            navController,
            this
        )

        navigationProvider.pokemonApi.registerGraph(
            navController,
            this
        )
    }
}