package com.example.tp1_master2_ccm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp1_master2_ccm.ui.screen.DogsImageScreen
import com.example.tp1_master2_ccm.ui.screen.ListScreen
import com.example.tp1_master2_ccm.ui.screen.MainScreen
import com.example.tp1_master2_ccm.ui.screen.QuoteScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val QUOTE_SCREEN = "quote_screen"
    const val DOGS_SCREEN = "dogs_screen"

}


fun NavGraphBuilder.addMainScreenNavigation(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit
) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            },
            onButton2Click = {
                onButton2Click()
            },
            onButton3Click = {
                onButton3Click()
            },

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

fun NavGraphBuilder.addQuoteScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.QUOTE_SCREEN,
    ) {
        QuoteScreen(navController)
    }
}

fun NavGraphBuilder.addDogScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.DOGS_SCREEN,
    ) {
        DogsImageScreen(navController)
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
            },
                    onButton2Click = {
                navController.navigate(NavigationPath.QUOTE_SCREEN)
            },
            onButton3Click = {
                navController.navigate(NavigationPath.DOGS_SCREEN)
            }
        )
        addListScreenNavigation(navController = navController)
        addQuoteScreenNavigation(navController= navController,)
        addDogScreenNavigation(navController = navController)
    }
}

