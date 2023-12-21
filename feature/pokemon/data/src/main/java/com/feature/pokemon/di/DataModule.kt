package com.feature.pokemon.di

import com.feature.pokemon_list.domain.repository.IPokemonRepository
import com.feature.pokemon_list.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {
    @ViewModelScoped
    @Binds
    fun bindMovieRepository(repository: com.feature.pokemon_list.data.repository.PokemonRepositoryImpl): com.feature.pokemon_list.domain.repository.IPokemonRepository
}