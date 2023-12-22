package com.feature.pokemon_list.ui

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.feature.pokemon_list.domain.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonVieModel,
    navController: NavController,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState = viewModel.uiState.value

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("PocketMon Insight")
                },
                actions = {
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
            uiState = uiState,
            navController = navController
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
    navController: NavController?,
) {
    val pokemon = uiState.pokemon

    LazyColumn(modifier = modifier) {
        pokemon?.let {
            items(it.size) { index ->
                val currPokemon = pokemon[index]
                val url = currPokemon?.url?.split("/")
                val id = url?.getOrNull(url.size - 2) ?: ""

                Log.d("id value", id)
                PokemonItem(
                    name = currPokemon?.name,
                    modifier = Modifier
                        .clickable {
                            navController?.navigate("pokemon_info_screen_route/${id}")
                        }
                )
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
fun PokemonItem(name: String?, modifier: Modifier) {
    Row(
        modifier = modifier
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
            ),
            navController = null
        )
    }
}