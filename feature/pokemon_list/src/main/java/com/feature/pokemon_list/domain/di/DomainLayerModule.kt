package com.feature.pokemon_list.domain.di

import com.feature.pokemon_list.domain.repository.IPokemonRepository
import com.feature.pokemon_list.domain.use_case.GetPokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

}