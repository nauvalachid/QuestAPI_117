package com.example.pokedex.ui.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.Navigation.DestinasiNavigasi
import com.example.pokedex.ui.viewmodel.HomeViewModel
import com.example.pokedex.ui.viewmodel.PenyediaViewModel

object DestinasiHome : DestinasiNavigasi{
    override val route = "home"
    override val titleRes = "Home Mhs"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry:()-> Unit,
    modifier: Modifier=Modifier,
    onDetailClick:(String)->Unit = {},
    viewModel:HomeViewModel=viewModel(factory=PenyediaViewModel.Factory)
){}