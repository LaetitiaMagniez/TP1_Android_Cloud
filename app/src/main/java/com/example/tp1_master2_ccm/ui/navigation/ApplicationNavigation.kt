package com.example.tp1_master2_ccm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp1_master2_ccm.ui.screen.ListScreen
import com.example.tp1_master2_ccm.ui.screen.MainScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
}


fun NavGraphBuilder.addMainScreenNavigation(
    onButtonClick: () -> Unit,
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            }
        )
    }
}


fun NavGraphBuilder.addListScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        ListScreen(navController)
    }
}

@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNavigation(
            onButtonClick = {
                navController.navigate(NavigationPath.LIST_SCREEN)
            }
        )
        addListScreenNavigation(navController = navController)
    }
}

