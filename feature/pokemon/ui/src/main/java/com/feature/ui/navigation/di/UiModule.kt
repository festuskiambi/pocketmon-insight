package com.feature.ui.navigation.di

import com.feature.ui.navigation.PokemonApi
import com.feature.ui.navigation.PokemonApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
     @Provides
     fun providePokemonApi(): PokemonApi {
         return PokemonApiImpl()
     }
}