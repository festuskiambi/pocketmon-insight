package com.feature.pokemon.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)