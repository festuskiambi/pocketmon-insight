package com.feature.pokemon_list.domain.repository

import com.feature.pokemon_list.domain.model.Pokemon

interface IPokemonRepository {
    suspend fun getPokemon(): List<Pokemon?>?
}