package com.feature.pokemon.data.remote.model

import com.feature.domain.model.Pokemon

fun PokemonDto.toDomainModel() = Pokemon(
    name = name,
    url = url
)