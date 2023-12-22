package com.feature.pokemon_info.domain.model

data class PokemonInfo(
    val name: String?,
    val id: Int,
    val frontSpriteUrl: String?,
    val stats: List<Stat?>?

)
