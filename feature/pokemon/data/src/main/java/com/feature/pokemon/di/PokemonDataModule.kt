package com.feature.pokemon.di

import com.feature.domain.repository.IPokemonRepository
import com.feature.pokemon.data.remote.PokemonApi
import com.feature.pokemon.data.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PokemonDataModule {
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Provides
    fun providePokemonRepository(): IPokemonRepository{
        return PokemonRepositoryImpl()
    }
}