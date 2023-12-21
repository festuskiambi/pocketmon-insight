package com.feature.pokemon_list.data.repository

import com.feature.pokemon_list.domain.model.Pokemon
import com.feature.pokemon_list.domain.repository.IPokemonRepository
import com.feature.pokemon_list.data.remote.PokemonApi
import com.feature.pokemon_list.data.remote.model.toDomainModel
import javax.inject.Inject

 class PokemonRepositoryImpl @Inject constructor(
     private val api: PokemonApi
) : IPokemonRepository {
    override suspend fun getPokemon(): List<Pokemon?>? {
        return api.getPokeMon().pokemon?.map {
            it?.toDomainModel()
        }
    }
}