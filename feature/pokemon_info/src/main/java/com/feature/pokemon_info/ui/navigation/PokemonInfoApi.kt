package com.feature.pokemon_info.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.feature_api.FeatureApi

interface PokemonInfoApi: FeatureApi {
}

class PokemonInfoApiImpl(): PokemonInfoApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder,
    ) {
        InternalPokemonInfoFeatureApi.registerGraph(
            navHostController, navGraphBuilder
        )
    }
}

