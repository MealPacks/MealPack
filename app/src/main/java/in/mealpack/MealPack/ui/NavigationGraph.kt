package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.ui.Login.LoginScreen
import `in`.mealpack.mealpack_testing_new_things.ui.components.meals.MealScreen
import `in`.mealpack.ui_login.ui.LoginViewModel
import `in`.mealpack.ui_meals.meal_details.ShowMealDetailScreen
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import coil.ImageLoader
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SetUpNavGraph(navController: NavHostController, imageLoader: ImageLoader) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        builder = {
            SplashScreenBuilder(navController)
            LoginBuilder(navController, imageLoader)
            MainScreenBuilder(navController, imageLoader)
        }
    )
}


fun NavGraphBuilder.SplashScreenBuilder(
    navController: NavHostController
) {
    composable(
        route = Screen.SplashScreen.route
    ) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        SplashScreen {
            if (currentUser != null) {
                currentUser?.let {
                    navController.navigate(Screen.MealsScreen.sendUserId("1")) {
                        popUpTo(Screen.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                navController.navigate(Screen.LoginScreen.route){
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }

        }

    }

}


fun NavGraphBuilder.LoginBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.LoginScreen.route
    ) {
        val loginViewModel: LoginViewModel = hiltViewModel()
        LoginScreen(
            loginViewModel = loginViewModel,
            onSuccessUserAuth = {
                navController.navigate(
                    Screen.MealsScreen.sendUserId(it.userid)
                ) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
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
        route = Screen.MealsScreen.route,
        arguments = listOf(navArgument(USER_ID) {
            defaultValue = "0"
        })
    ) {
        Log.d("MealScreen", "${it.arguments?.get(USER_ID)}")
        Scaffold {

        }
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
