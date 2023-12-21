package com.feature.pokemon_list.data.remote.model


import com.google.gson.annotations.SerializedName

data class GetPokemonResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val list: List<PokemonDto?>?
)