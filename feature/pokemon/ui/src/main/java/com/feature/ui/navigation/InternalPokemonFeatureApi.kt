package com.feature.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.PokemonFeature
import com.example.feature_api.FeatureApi
import com.feature.ui.PokemonScreen

internal object InternalPokemonFeatureApi: FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(
            startDestination = PokemonFeature.SCREEN_ROUTE,
            route = PokemonFeature.NESTED_ROUTE ){
         composable(PokemonFeature.SCREEN_ROUTE,){
             PokemonScreen()
         }
        }
    }
}