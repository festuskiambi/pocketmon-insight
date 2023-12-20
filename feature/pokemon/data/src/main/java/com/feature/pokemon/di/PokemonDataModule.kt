package com.feature.pokemon.di

import com.feature.pokemon.data.remote.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PokemonDataModule {
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)
}