package com.feature.pokemon_list.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.core.common.UserMessage
import com.feature.pokemon_list.domain.model.Pokemon
import com.feature.pokemon_list.domain.use_case.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val STOP_TIMEOUT_MILLIS: Long = 5000
val WhileUiSubscribed: SharingStarted = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS)

@HiltViewModel
class PokemonVieModel @Inject constructor(
    private val useCase: GetPokemonUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(PokemonUiState())
    val uiState: State<PokemonUiState> get() = _state

    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            useCase.invoke().onEach {
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
                        _state.value = PokemonUiState(pokemon = it.data)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}

data class PokemonUiState(
    val pokemon: List<Pokemon?>? = null,
    val isLoading: Boolean? = false,
    val userMessage: UserMessage? = null,
)
