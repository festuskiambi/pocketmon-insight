package com.feature.pokemon.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPokemonResponse(
    @SerialName("results")
    val pokemon: List<PokemonDto?>?
)