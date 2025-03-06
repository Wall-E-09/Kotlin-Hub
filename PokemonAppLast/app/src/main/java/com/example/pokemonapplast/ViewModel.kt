package com.example.pokemonapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.api.PokeApiService
import com.example.pokemonapp.model.PokemonDetailResponse
import kotlinx.coroutines.launch
import kotlin.random.Random

class PokemonViewModel : ViewModel() {
    private val apiService = PokeApiService.create()
    var pokemonList by mutableStateOf<List<PokemonDetailResponse>>(emptyList())
        private set
    var isDropDownMenuOpen by mutableStateOf(false)
        private set

    fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = apiService.getPokemonList()
                val randomSize = Random.nextInt(8)
                val selectedPokemon = response.results.shuffled().take(randomSize)
                val details = selectedPokemon.mapNotNull {
                    try {
                        apiService.getPokemonDetails(it.name)
                    } catch (e: Exception) {
                        null
                    }
                }
                pokemonList = details
            } catch (e: Exception) {
                pokemonList = emptyList()
            }
        }
    }

    fun toggleDropDownMenu() {
        isDropDownMenuOpen = !isDropDownMenuOpen
    }

    fun closeDropDownMenu() {
        isDropDownMenuOpen = false
    }

    fun sortByName() {
        pokemonList = pokemonList.sortedBy { it.name }
        closeDropDownMenu()
    }

    fun sortByNameReverse() {
        pokemonList = pokemonList.sortedByDescending { it.name }
        closeDropDownMenu()
    }

    fun sortByMoves() {
        pokemonList = pokemonList.sortedBy { it.moves.joinToString { move -> move.move.name } }
        closeDropDownMenu()
    }

    fun sortByMovesReverse() {
        pokemonList = pokemonList.sortedByDescending { it.moves.joinToString { move -> move.move.name } }
        closeDropDownMenu()
    }
}