package com.example.pokedex.ui.viewmodel

import com.example.pokedex.model.Mahasiswa

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>): HomeUiState()
    object Error:HomeUiState()
    object Loading:HomeUiState()
}