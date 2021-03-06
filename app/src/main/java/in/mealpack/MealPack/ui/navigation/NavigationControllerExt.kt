package `in`.mealpack.MealPack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavHostController.currentRoute(): String? {
    val navBackStackEntry by this.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


fun NavHostController.getCurrentRoute(): String? {
    val navBackStackEntry = this.currentBackStackEntry
    return navBackStackEntry?.destination?.route
}

