package com.feature.pokemon_list.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonVieModel
) {
    PokemonList()
}

@Composable
fun PokemonList() {
    val scrabbleTiles = generateScrabbleTiles()

    LazyColumn {
        items(scrabbleTiles.size) { index ->
            PokemonItem(tile = scrabbleTiles[index])
            if (index < scrabbleTiles.size - 1) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun PokemonItem(tile: Char) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(tile.toString())

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Send",
            modifier = Modifier.size(24.dp)
        )
    }
}

fun generateScrabbleTiles(): List<Char> {
    val tiles = mutableListOf<Char>()
    repeat(7) {
        val randomLetter = ('A'..'Z').random()
        tiles.add(randomLetter)
    }
    return tiles
}

@Preview
@Composable
fun PokemonScreenPreview(
) {
    Surface {
        PokemonList()
    }
}