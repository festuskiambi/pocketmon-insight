package com.feature.pokemon_list.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.PokemonFeature
import com.example.feature_api.FeatureApi
import com.feature.pokemon_list.ui.PokemonScreen
import com.feature.pokemon_list.ui.PokemonVieModel

internal object InternalPokemonFeatureApi : FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(
            startDestination = PokemonFeature.SCREEN_ROUTE,
            route = PokemonFeature.NESTED_ROUTE
        ) {
            composable(PokemonFeature.SCREEN_ROUTE) {
                val viewModel = hiltViewModel<PokemonVieModel>()
                PokemonScreen(viewModel = viewModel, navController = navHostController)
            }
        }
    }
}