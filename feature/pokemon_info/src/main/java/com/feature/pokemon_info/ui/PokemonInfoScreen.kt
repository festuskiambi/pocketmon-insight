package com.feature.pokemon_info.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.feature.pokemon_info.domain.model.Stat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonInfoScreen(
    modifier: Modifier = Modifier,
    id: String,
    viewModel: PokemonInfoViewModel,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState = viewModel.uiState.value

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    uiState.pokemonInfo?.name?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        )
                    }
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },

        ) { paddingValues ->
        PokemonDetailsContent(
            modifier = modifier.padding(paddingValues),
            uiState = uiState,
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
fun PokemonDetailsContent(
    modifier: Modifier = Modifier,
    uiState: PokemonUiState,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uiState.pokemonInfo?.frontSpriteUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "front sprite",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Stats",
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(8.dp)
            )

            PokemonStatsList(stats = uiState.pokemonInfo?.stats)
        }
    }
}

@Composable
fun PokemonStatsList(stats: List<Stat?>?) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        stats?.let {
            items(it.size) { index ->
                val stat = stats[index]
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    stat?.name?.let { name ->
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    stat?.baseStat?.let { baseStat ->
                        Text(
                            text = baseStat.toString(),
                            style = MaterialTheme.typography.bodyMedium,

                            )
                    }
                }
            }
        }
    }
}