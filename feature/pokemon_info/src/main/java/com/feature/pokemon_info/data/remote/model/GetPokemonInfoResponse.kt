package com.feature.pokemon_info.data.remote.model


import com.google.gson.annotations.SerializedName

data class GetPokemonInfoResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sprites")
    val sprites: Sprites?,
    @SerializedName("stats")
    val stats: List<Stat>?
)