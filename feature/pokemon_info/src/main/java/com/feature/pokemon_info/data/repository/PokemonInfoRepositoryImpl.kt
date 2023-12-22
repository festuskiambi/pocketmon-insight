package com.feature.pokemon_info.data.repository

import com.feature.pokemon_info.data.mapper.toDomainModel
import com.feature.pokemon_info.data.remote.PokemonInfoApiInterface
import com.feature.pokemon_info.domain.model.PokemonInfo
import com.feature.pokemon_info.domain.repository.IPokemonInfoRepositoryInfo
import javax.inject.Inject

class PokemonInfoRepositoryImpl @Inject constructor(
    private val api: PokemonInfoApiInterface,
) : IPokemonInfoRepositoryInfo {
    override suspend fun getPokemonInfo(id: String?): PokemonInfo {
        return api.getPokeMon(id).toDomainModel()
    }
}