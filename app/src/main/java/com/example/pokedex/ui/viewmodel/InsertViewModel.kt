package com.example.pokedex.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pokedex.repository.MahasiswaRepository

class InsertViewModel(private val mhs: MahasiswaRepository): ViewModel(){
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertMhsState(insertUiEvent.InsertUiEvent) {
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }
}