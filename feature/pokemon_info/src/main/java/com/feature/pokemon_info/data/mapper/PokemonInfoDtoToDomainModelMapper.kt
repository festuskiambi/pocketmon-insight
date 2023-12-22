package com.feature.pokemon_info.data.mapper

import com.feature.pokemon_info.data.remote.model.GetPokemonInfoResponse
import com.feature.pokemon_info.data.remote.model.StatDto
import com.feature.pokemon_info.domain.model.PokemonInfo
import com.feature.pokemon_info.domain.model.Stat

fun GetPokemonInfoResponse.toDomainModel() = PokemonInfo(
    name = name,
    id = id,
    frontSpriteUrl = sprites?.frontDefault,
    stats = getStats(statDtos)
)

fun getStats(statDtos: List<StatDto?>?): List<Stat?>? {
    val stats = mutableListOf<Stat>()

    statDtos?.let { dtos ->
        for (dto in dtos) {
            val stat = Stat(
                name = dto?.stat?.name,
                baseStat = dto?.baseStat
            )
            stats.add(stat)
        }
    }
    return stats
}


