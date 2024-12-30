package com.example.pokedex.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.ui.view.DestinasiDetail
import com.example.pokedex.ui.view.DestinasiEntry
import com.example.pokedex.ui.view.DestinasiHome
import com.example.pokedex.ui.view.DestinasiUpdate
import com.example.pokedex.ui.view.DetailView
import com.example.pokedex.ui.view.EntryMhsScreen
import com.example.pokedex.ui.view.HomeScreen
import com.example.pokedex.ui.view.UpdateView

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { nim ->
                    if (nim.isNotEmpty()) {
                        navController.navigate("${DestinasiDetail.route}/$nim")
                    }
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntryMhsScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) { inclusive = true }
                    }
                }
            )
        }
        composable(
            route = "${DestinasiDetail.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            DetailView(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                },
                onClick = {
                    // Navigate to the update screen when FAB is clicked
                    navController.navigate("${DestinasiUpdate.route}/$nim")
                }
            )
        }

        // Update Screen
        composable(
            route = "${DestinasiUpdate.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            UpdateView(
                nim = nim,
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

