package com.feature.domain.di

import com.feature.domain.repository.IPokemonRepository
import com.feature.domain.use_case.GetPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetMovieUseCase(repository: IPokemonRepository): GetPokemonUseCase{
        return GetPokemonUseCase(repository)
    }
}