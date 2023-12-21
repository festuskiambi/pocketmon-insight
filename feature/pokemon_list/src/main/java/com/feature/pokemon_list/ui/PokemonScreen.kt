package com.feature.pokemon_list.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.feature.pokemon_list.domain.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonVieModel,
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val uiState  = viewModel.uiState.value

    Log.d("ui poke", uiState.toString())

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokemon Insight")
                },
                actions = {
                    // You can add actions (icons or other UI elements) here
                    IconButton(
                        onClick = { /* Handle action click */ }
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Send")
                    }
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },

        ) { paddingValues ->
        PokemonScreenContent(
            modifier = modifier.padding(paddingValues),
            uiState = uiState
        )

        uiState.userMessage?.let { userMessage ->
            val snackbarText = userMessage.message?.asString()

            LaunchedEffect(snackbarHostState) {
                if (snackbarText != null) {
                    snackbarHostState.showSnackbar(
                        message = snackbarText
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonScreenContent(
    modifier: Modifier = Modifier,
    uiState: PokemonUiState,
) {
    val pokemon = uiState.pokemon

    Log.d("ui poke", pokemon.toString())

    LazyColumn {
        pokemon?.let {
            items(it.size) { index ->
                PokemonItem(name = pokemon[index]?.name)
                if (index < pokemon.size - 1) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonItem(name: String?) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        name?.let { Text(it) }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Send",
            modifier = Modifier.size(24.dp)
        )
    }
}


@Preview
@Composable
fun PokemonScreenPreview(
) {
    Surface {
        PokemonScreenContent(
            uiState = PokemonUiState(
                pokemon = listOf(
                    Pokemon(
                        name = "bulbasau",
                        url = ""
                    ),
                    Pokemon(
                        name = "ivysaur",
                        url = ""
                    ),
                    Pokemon(
                        name = "venusaur",
                        url = ""
                    )
                )
            )
        )
    }
}