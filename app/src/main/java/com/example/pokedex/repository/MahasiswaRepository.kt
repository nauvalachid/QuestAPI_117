package com.example.pokedex.repository

import com.example.pokedex.model.Mahasiswa
import okio.IOException

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiwa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    suspend fun getMahasiswaBynim(nim: String):Mahasiswa
}

class NetworkMahasiswaRepository(
):MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }
    override suspend fun updateMahasiswa(nim: String,mahasiswa: Mahasiswa){
        mahasiswaApiService.updateMahasiswa(nim,mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response : mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful){
                throw IOException("Failed to delete kontak")
            }
        }
    }
    }
)