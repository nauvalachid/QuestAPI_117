package com.example.pokedex.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.view.DestinasiEntry
import com.example.pokedex.ui.view.DestinasiHome
import com.example.pokedex.ui.view.EntryMhsScreen
import com.example.pokedex.ui.view.HomeScreen

@Composable
fun PengelolaHalaman(navController:NavHostController= rememberNavController()){
    NavHost(
        navController=navController,
        startDestinastion=DestinasiHome.route,
        modifier=Modifier,
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry={navController.navigate(DestinasiEntry)},
                onDetailClick={
                }
            )
        }
        composable(DestinasiEntry.route){
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route){
                    PopUpTo(DestinasiHome.route){
                        inclusive=true
                    }
                }
            })
        }
    }
}