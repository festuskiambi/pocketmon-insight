package com.feature.pokemon_info.domain.use_case

import com.core.common.UiEvent
import com.feature.pokemon_info.domain.model.PokemonInfo
import com.feature.pokemon_info.domain.repository.IPokemonInfoRepositoryInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val repository: IPokemonInfoRepositoryInfo,
) {
    operator fun invoke(id: String?) = flow<UiEvent<PokemonInfo?>> {
        emit(UiEvent.Loading())
        val result = repository.getPokemonInfo(id)
        emit(UiEvent.Success(data = result))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}