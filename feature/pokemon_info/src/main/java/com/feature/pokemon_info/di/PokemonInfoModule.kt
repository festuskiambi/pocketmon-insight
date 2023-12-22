package com.feature.pokemon_info.di

import com.feature.pokemon_info.data.remote.PokemonInfoApiInterface
import com.feature.pokemon_info.data.repository.PokemonInfoRepositoryImpl
import com.feature.pokemon_info.domain.repository.IPokemonInfoRepositoryInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object PokemonInfoModule {
    @Provides
    fun providePokemonInfoApiInterface(retrofit: Retrofit): PokemonInfoApiInterface =
        retrofit.create(PokemonInfoApiInterface::class.java)

    @Provides
    fun providePokemonInfoRepository(api: PokemonInfoApiInterface): IPokemonInfoRepositoryInfo {
        return PokemonInfoRepositoryImpl(api)
    }
}