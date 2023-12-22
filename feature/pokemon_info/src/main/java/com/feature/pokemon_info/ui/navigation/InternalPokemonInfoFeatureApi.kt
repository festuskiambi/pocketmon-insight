package com.feature.pokemon_info.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.PokemonInfoFeature
import com.example.feature_api.FeatureApi
import com.feature.pokemon_info.ui.PokemonInfoScreen
import com.feature.pokemon_info.ui.PokemonInfoViewModel

internal object InternalPokemonInfoFeatureApi : FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(
            route = PokemonInfoFeature.NESTED_ROUTE,
            startDestination = PokemonInfoFeature.SCREEN_ROUTE
        ) {
            composable(PokemonInfoFeature.SCREEN_ROUTE) {
                val id = it.arguments?.getString("id")
                val viewModel = hiltViewModel<PokemonInfoViewModel>()
                PokemonInfoScreen(id = id.toString(), viewModel = viewModel)
            }
        }
    }
}