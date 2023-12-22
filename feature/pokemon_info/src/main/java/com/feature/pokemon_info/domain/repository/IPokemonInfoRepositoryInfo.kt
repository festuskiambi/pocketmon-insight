package com.feature.pokemon_info.domain.repository

import com.feature.pokemon_info.domain.model.PokemonInfo

interface IPokemonInfoRepositoryInfo {
    suspend fun getPokemonInfo(id: String?): PokemonInfo
}