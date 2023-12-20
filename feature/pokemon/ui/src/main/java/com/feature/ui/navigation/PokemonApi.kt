package com.feature.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.feature_api.FeatureApi

interface PokemonApi: FeatureApi {
}

class  PokemonApiImpl: PokemonApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        InternalPokemonFeatureApi.registerGraph(
            navHostController, navGraphBuilder
        )
    }
}