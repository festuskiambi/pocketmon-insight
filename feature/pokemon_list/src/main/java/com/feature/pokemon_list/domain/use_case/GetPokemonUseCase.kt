package com.feature.pokemon_list.domain.use_case

import android.util.Log
import com.core.common.UiEvent
import com.feature.pokemon_list.domain.model.Pokemon
import com.feature.pokemon_list.domain.repository.IPokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: IPokemonRepository
) {
    operator fun invoke() = flow<UiEvent<List<Pokemon?>?>> {
        Log.e("Debug", "got to usecase")

        emit(UiEvent.Loading())
         emit(UiEvent.Success(repository.getPokemon()))
    }.catch {
        Log.e("Debug", it.toString())

        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}