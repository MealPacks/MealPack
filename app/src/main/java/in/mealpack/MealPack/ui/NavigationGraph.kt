package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.ui.Login.LoginScreen
import `in`.mealpack.MealPack.ui.navigation.createRouter
import `in`.mealpack.ui_login.ui.LoginViewModel
import `in`.mealpack.ui_meals.choose_plan.ChoosePlanPopUp
import `in`.mealpack.ui_meals.meal_details.MealDetailScreen
import `in`.mealpack.ui_meals.meals.MealsViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import coil.ImageLoader
import com.google.firebase.auth.FirebaseAuth

@ExperimentalMaterialApi
@Composable
fun SetUpNavGraph(navController: NavHostController, imageLoader: ImageLoader) {
    val mealsViewModel: MealsViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        builder = {
            SplashScreenBuilder(navController)
            LoginBuilder(navController, imageLoader)
            MainScreenBuilder(mealsViewModel, navController, imageLoader)
            MealDetailScreenBuilder(mealsViewModel, navController, imageLoader)
            ProfileScreenBuilder(navController, imageLoader)
            GiveFeedBackBuilder(navController, imageLoader)
            HelpAndSupportBuilder(navController, imageLoader)
            OrderScreenBuilder(navController, imageLoader)
        }
    )
}

fun NavGraphBuilder.OrderScreenBuilder(navController: NavHostController, imageLoader: ImageLoader) {
//    composable(route = Screen.OrderScreen.route)
//    composable()
}

fun NavGraphBuilder.MealDetailScreenBuilder(
    mealsViewModel: MealsViewModel,
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(route = Screen.MealDetailScreen.route,
        arguments = listOf(
            navArgument(MEAL_DETAIL_MEAL_ID_KEY) {
                type = NavType.StringType
            },
            navArgument(MEAL_DETAIL_CART_ID_KEY) {
                type = NavType.IntType
            }
        )
    ) {
        MealDetailScreen(
            mealsViewModel = mealsViewModel,
            imageLoader = imageLoader,
            backClicked = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.HelpAndSupportBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.HelpAndSupportScreen.route
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            Column {
                Text(text = "Help And Support")
                Button(
                    onClick = { navController.navigate(Screen.MainScreen.route) }
                ) {
                    Text(text = "Take me to the Main Screen")
                }
            }
        }
    }
}

fun NavGraphBuilder.GiveFeedBackBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.FeedbackScreen.route
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            Column {
                Text(text = "Give Feedback")
                Button(
                    onClick = { navController.navigate(Screen.MainScreen.route) }
                ) {
                    Text(text = "Take me to the Main Screen")
                }
            }
        }
    }
}

fun NavGraphBuilder.ProfileScreenBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.ProfileScreen.route
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            Column {
                Text(text = "Profile Screen")
                Button(
                    onClick = { navController.navigate(Screen.MainScreen.route) }
                ) {
                    Text(text = "Take me to the Main Screen")
                }
            }
        }
    }
}


@ExperimentalMaterialApi
fun NavGraphBuilder.MainScreenBuilder(
    mealsViewModel: MealsViewModel,
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(route = Screen.MainScreen.route,
        arguments = listOf(
            navArgument(MAIN_SCREEN_USER_ID_KEY) {
                type = NavType.StringType
            }
        )
    ) {

        MainScreen(
            userId = it.arguments?.getString(MAIN_SCREEN_USER_ID_KEY) ?: "0",
            mealsViewModel,
            imageLoader,
            createRouter { route ->
                navController.navigate(route)
            }
        )
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
                    Screen.MainScreen.sendUserId(it.userid)
                ) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
                }
            },
            onSkipClicked = {
                navController.navigate(
                    Screen.MainScreen.sendUserId("01")
                ) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
                }
            }
        )


    }
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
                    navController.navigate(Screen.MainScreen.sendUserId("1")) {
                        popUpTo(Screen.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                navController.navigate(Screen.LoginScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }

        }

    }

}