package com.feature.pokemon_info.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.feature.pokemon_info.domain.use_case.GetPokemonInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonInfoViewModel @Inject constructor(
private val useCase: GetPokemonInfoUseCase,
savedStateHandle: SavedStateHandle
): ViewModel() {

}