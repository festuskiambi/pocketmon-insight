package com.feature.pokemon_info.data.remote.model


import com.google.gson.annotations.SerializedName

data class StatDetails(
    @SerializedName("name")
    val name: String?
)