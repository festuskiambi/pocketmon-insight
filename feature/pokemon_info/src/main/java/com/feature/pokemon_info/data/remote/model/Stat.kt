package com.feature.pokemon_info.data.remote.model


import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int?,
    @SerializedName("stat")
    val stat: StatDetails?
)