package com.feature.pokemon_list.data.remote.model


import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)