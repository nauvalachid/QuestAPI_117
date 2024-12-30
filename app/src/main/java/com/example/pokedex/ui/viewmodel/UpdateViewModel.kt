package com.example.pokedex.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.Mahasiswa
import com.example.pokedex.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class UpdateViewModel(private val mhs: MahasiswaRepository) : ViewModel(){
    var uiState by mutableStateOf(UpdateUiState())
        private set

    fun loadMahasiswa(nim: String){
        viewModelScope.launch {
            try{
                val mahasiswa = mhs.getMahasiswaById(nim)
                uiState = UpdateUiState(updateUiEvent = mahasiswa.toUpdateUiEvent())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun updateMahasiswaState(updateUiEvent: UpdateUiEvent){
        uiState = UpdateUiState(updateUiEvent = updateUiEvent)
    }

    suspend fun updateMahasiswa(nim: String) {
        viewModelScope.launch {
            try {
                mhs.updateMahasiwa(nim,uiState.updateUiEvent.toMahasiswa())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}

data class UpdateUiState(
    val updateUiEvent : UpdateUiEvent = UpdateUiEvent()
)

data class UpdateUiEvent(
    val nim: String = "",
    val nama: String ="",
    val alamat: String ="",
    val jenisKelamin: String ="",
    val kelas:  String="",
    val angkatan: String=""
)

fun UpdateUiEvent.toMahasiswa(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)

fun Mahasiswa.toUpdateUiEvent(): UpdateUiEvent = UpdateUiEvent(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)