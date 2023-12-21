package com.feature.pokemon_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.Async
import com.core.common.UserMessage
import com.feature.domain.model.Pokemon
import com.feature.domain.repository.IPokemonRepository
import com.feature.domain.use_case.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

private const val STOP_TIMEOUT_MILLIS: Long = 5000
val WhileUiSubscribed: SharingStarted = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS)

@HiltViewModel
class PokemonVieModel @Inject constructor(
    private val useCase: GetPokemonUseCase
) : ViewModel() {

    private val userMessageChannel = Channel<UserMessage?>()
    val messages = userMessageChannel.receiveAsFlow()

    private val isLoading = MutableStateFlow(false)
    private val _pokemonAsync: MutableStateFlow<Async<List<Pokemon>>> = MutableStateFlow(Async.Loading)

    val uiState: StateFlow<PokemonUiState> = combine(
        isLoading,
        messages,
        _pokemonAsync,
    ) { isLoading, messages, pokemonAsync ->
        when ( pokemonAsync) {
            is Async.Loading -> PokemonUiState(isLoading = true)
            is Async.Success -> {
                PokemonUiState(
                    isLoading = isLoading,
                    userMessage = messages,
                    pokemon = pokemonAsync.data
                )
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = PokemonUiState(isLoading = true),
    )
}

data class PokemonUiState(
    val pokemon: List<Pokemon>? = null,
    val isLoading: Boolean? = false,
    val userMessage: UserMessage? = null,
)
