package com.example.pocketmoninsight.di

import com.example.pocketmoninsight.navigation.NavigationProvider
import com.feature.ui.navigation.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideNavigationProvider(pokemonApi: PokemonApi): NavigationProvider {
        return NavigationProvider(pokemonApi)
    }
}