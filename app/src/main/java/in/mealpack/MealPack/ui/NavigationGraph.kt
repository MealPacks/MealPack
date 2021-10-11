package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.ui.Login.LoginScreen
import `in`.mealpack.mealpack_testing_new_things.ui.components.meals.MealScreen
import `in`.mealpack.ui_meals.meal_details.ShowMealDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun SetUpNavGraph(navController: NavHostController, imageLoader: ImageLoader) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
        builder = {
            LoginBuilder(navController, imageLoader)
            MainScreenBuilder(navController, imageLoader)
        }
    )
}


fun NavGraphBuilder.LoginBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.LoginScreen.route,
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.currentUser?.let {
            navController.navigate(Screen.MealsScreen.route) {
                popUpTo(Screen.LoginScreen.route) {
                    inclusive = true
                }
            }
        }
        LoginScreen(currentUser = null,
            onSuccessUserAuth = {
                val currentUser = Firebase.auth.currentUser
                currentUser?.let {
                    navController.navigate(
                        Screen.MealsScreen.route
                    )
                }

            }
        )


    }
}

fun NavGraphBuilder.MainScreenBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.MealsScreen.route
    ) {
        MealScreen {
            navController.navigate(Screen.MealsDetailsScreen.route)
        }
    }
    composable(
        route = Screen.MealsDetailsScreen.route
    ) {
        ShowMealDetailScreen()
    }
}
