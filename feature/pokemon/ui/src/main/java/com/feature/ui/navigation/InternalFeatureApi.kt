package com.feature.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.feature_api.FeatureApi
import com.feature.ui.PokemonScreen

object InternalFeatureApi: FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        navGraphBuilder.navigation(startDestination = "Pokemon", route ="pokemon_nested_navigation" ){
         composable("Pokemon"){
             PokemonScreen()
         }
        }
    }
}