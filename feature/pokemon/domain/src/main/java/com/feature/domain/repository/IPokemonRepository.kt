package com.feature.domain.repository

import com.feature.domain.model.Pokemon

interface IPokemonRepository {
    suspend fun getPokemon(): List<Pokemon>
}