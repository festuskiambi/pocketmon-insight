package com.feature.pokemon_info.data.remote.model


import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String?
)