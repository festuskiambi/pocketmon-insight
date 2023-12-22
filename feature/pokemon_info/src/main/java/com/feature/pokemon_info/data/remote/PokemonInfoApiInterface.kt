package com.feature.pokemon_info.data.remote

import com.feature.pokemon_info.data.remote.model.GetPokemonInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInfoApiInterface {
    @GET("pokemon/{id}/")
    suspend fun getPokeMon(
        @Path("id") id: String?,
    ): GetPokemonInfoResponse
}