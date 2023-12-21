package com.feature.pokemon_list.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.Async
import com.core.common.UiEvent
import com.core.common.UserMessage
import com.feature.pokemon_list.domain.model.Pokemon
import com.feature.pokemon_list.domain.use_case.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val STOP_TIMEOUT_MILLIS: Long = 5000
val WhileUiSubscribed: SharingStarted = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS)

@HiltViewModel
class PokemonVieModel @Inject constructor(
    private val useCase: GetPokemonUseCase,
) : ViewModel() {

    private val userMessageChannel = Channel<UserMessage?>()
    val messages = userMessageChannel.receiveAsFlow()

    private val isLoading = MutableStateFlow(false)
    private val _pokemonAsync: MutableStateFlow<Async<List<Pokemon?>?>> =
        MutableStateFlow(Async.Loading)

    val uiState: StateFlow<PokemonUiState> = combine(
        isLoading,
        messages,
        _pokemonAsync,
    ) { isLoading, messages, pokemonAsync ->
        when (pokemonAsync) {
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

    init {
        getPokemon()
    }
    private fun getPokemon() {
        Log.e("Debug", "got to get pokemon")
        viewModelScope.launch {
            useCase.invoke().onEach {
                when (it) {
                    is UiEvent.Loading -> {
                        Log.e("Debug", "loa")

                        _pokemonAsync.value = Async.Loading
                    }

                    is UiEvent.Error -> {
                        Log.e("Debug", it.message.toString())

                        userMessageChannel.send(
                            UserMessage.SomethingWentWrong
                        )
                    }

                    is UiEvent.Success -> {
                        Log.e("Debug", "res")
                     _pokemonAsync.value = Async.Success(it.data)
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
