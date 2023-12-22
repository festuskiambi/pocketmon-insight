package com.example.pocketmoninsight.navigation

import com.feature.pokemon_info.ui.navigation.PokemonInfoApi
import com.feature.pokemon_list.ui.navigation.PokemonApi

data class NavigationProvider(
    val pokemonApi: PokemonApi,
    val pokemonInfoApi:PokemonInfoApi
)
