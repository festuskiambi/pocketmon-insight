package com.feature.pokemon_list.di

import com.feature.pokemon_list.data.remote.PokemonApiInterface
import com.feature.pokemon_list.data.repository.PokemonRepositoryImpl
import com.feature.pokemon_list.domain.repository.IPokemonRepository
import com.feature.pokemon_list.domain.use_case.GetPokemonUseCase
import com.feature.pokemon_list.ui.navigation.PokemonApi
import com.feature.pokemon_list.ui.navigation.PokemonApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): PokemonApiInterface =
        retrofit.create(PokemonApiInterface::class.java)


    @Provides
    fun providePokemonRepository(api: PokemonApiInterface): IPokemonRepository {
        return PokemonRepositoryImpl(api)
    }

    @Provides
    fun providePokemonApi(): PokemonApi {
        return PokemonApiImpl()
    }

    @Provides
    fun provideGetMovieUseCase(repository: IPokemonRepository): GetPokemonUseCase {
        return GetPokemonUseCase(repository)
    }
}