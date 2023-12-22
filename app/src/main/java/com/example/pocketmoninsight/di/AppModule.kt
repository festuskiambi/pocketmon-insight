package com.example.pocketmoninsight.di

import com.example.pocketmoninsight.navigation.NavigationProvider
import com.feature.pokemon_info.ui.navigation.PokemonInfoApi
import com.feature.pokemon_list.ui.navigation.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideNavigationProvider(
        pokemonApi: PokemonApi,
        pokemonInfoApi: PokemonInfoApi,
    ): NavigationProvider {
        return NavigationProvider(pokemonApi, pokemonInfoApi)
    }
}