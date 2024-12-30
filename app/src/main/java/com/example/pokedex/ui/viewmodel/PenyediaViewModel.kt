package com.example.pokedex.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedex.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository
            )
        }
        initializer {
            InsertViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository
            )
        }
        initializer {
            DetailViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository
            )
        }
        initializer {
            UpdateViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository
            )
        }
    }
}

    fun CreationExtras.aplikasiMahasiswa():MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MahasiswaApplications)