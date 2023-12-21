package com.feature.pokemon_list.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.feature_api.FeatureApi
import javax.inject.Inject

interface PokemonApi : FeatureApi {
}

class PokemonApiImpl @Inject constructor() : PokemonApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        InternalPokemonFeatureApi.registerGraph(
            navHostController, navGraphBuilder
        )
    }
}