package com.feature.pokemon_list.data.remote.model

import com.feature.pokemon_list.domain.model.Pokemon

fun PokemonDto.toDomainModel() = Pokemon(
    name = name,
    url = url
)