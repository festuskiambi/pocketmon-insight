package com.feature.pokemon_info.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.core.common.UserMessage
import com.feature.pokemon_info.domain.model.PokemonInfo
import com.feature.pokemon_info.domain.use_case.GetPokemonInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonInfoViewModel @Inject constructor(
    private val useCase: GetPokemonInfoUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(PokemonUiState())
    val uiState: State<PokemonUiState> get() = _state

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                Log.d("TAGGG", "${it}")

                getPokeMonInfo(it)
            }
        }
    }

    private fun getPokeMonInfo(id: String) {
        useCase.invoke(id = id).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _state.value = PokemonUiState(isLoading = true)
                }

                is UiEvent.Error -> {
                    _state.value = PokemonUiState(
                        userMessage = UserMessage.SomethingWentWrong
                    )
                }

                is UiEvent.Success -> {
                    _state.value = PokemonUiState(pokemonInfo = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class PokemonUiState(
    val pokemonInfo: PokemonInfo? = null,
    val isLoading: Boolean? = false,
    val userMessage: UserMessage? = null,
)