package com.feature.pokemon_info.ui

import androidx.lifecycle.ViewModel
import com.feature.pokemon_info.domain.use_case.GetPokemonInfoUseCase
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(
private val useCase: GetPokemonInfoUseCase
): ViewModel() {

}