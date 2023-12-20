package com.feature.pokemon.data.repository

import com.feature.domain.model.Pokemon
import com.feature.domain.repository.IPokemonRepository

class PokemonRepositoryImpl(): IPokemonRepository {
    override suspend fun getPokemon(): List<Pokemon> {
        TODO("Not yet implemented")
    }
}