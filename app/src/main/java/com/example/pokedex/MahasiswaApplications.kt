package com.example.pokedex

import android.app.Application
import com.example.pokedex.repository.AppContainer
import com.example.pokedex.repository.MahasiwaContainer

class MahasiswaApplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiwaContainer()
    }
}
