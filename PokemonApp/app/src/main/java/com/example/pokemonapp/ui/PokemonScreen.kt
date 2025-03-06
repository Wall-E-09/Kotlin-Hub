package com.example.pokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.pokemonapp.PokemonViewModel
import com.example.pokemonapp.model.PokemonDetailResponse

@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {
    LaunchedEffect(Unit) { viewModel.fetchPokemonList() }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(viewModel.pokemonList) { pokemon ->
                    PokemonItem(pokemon)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { viewModel.fetchPokemonList() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Reload Pokémon")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { viewModel.sortByName() },
                    modifier = Modifier.size(80.dp)
                ) {
                    Text(
                        "A-Z",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp)
                    )
                }
                Button(
                    onClick = { viewModel.sortByNameReverse() },
                    modifier = Modifier.size(80.dp)
                ) {
                    Text(
                        "Z-A",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp)
                    )
                }
                Button(
                    onClick = { viewModel.sortByMoves() },
                    modifier = Modifier.size(80.dp)
                ) {
                    Text(
                        "Moves A-Z",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp)
                    )
                }
                Button(
                    onClick = { viewModel.sortByMovesReverse() },
                    modifier = Modifier.size(80.dp)
                ) {
                    Text(
                        "Moves Z-A",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonItem(pokemon: PokemonDetailResponse) {
    Box(
        modifier = Modifier
            .padding(1.dp)
            .width(190.dp)
            .height(250.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(pokemon.sprites.front_default),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(140.dp)
            )

            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 1.dp)
            )

            val moves = pokemon.moves.take(2).joinToString { it.move.name }
            Text(
                text = "Moves: $moves",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
            )
        }
    }
}
