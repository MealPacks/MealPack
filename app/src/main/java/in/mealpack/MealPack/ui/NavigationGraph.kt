package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.ui.Login.LoginScreen
import `in`.mealpack.MealPack.ui.navigation.createRouter
import `in`.mealpack.ui_drawer.ui.ProfileScreen
import `in`.mealpack.ui_drawer.ui.feedback.FeedbackScreen
import `in`.mealpack.ui_drawer.ui.help_and_support.HelpAndSupportScreen
import `in`.mealpack.ui_drawer.ui.history.HistoryScreen
import `in`.mealpack.ui_login.ui.LoginViewModel
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
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.google.firebase.auth.FirebaseAuth

@ExperimentalMaterialApi
@Composable
fun SetUpNavGraph(navController: NavHostController, imageLoader: ImageLoader) {

    val bottomNavController = rememberNavController()


    val mealsViewModel: MealsViewModel = hiltViewModel()


    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        builder = {
            splashScreenBuilder(navController)
            loginBuilder(navController, imageLoader)
            mainScreenBuilder(mealsViewModel, navController,bottomNavController, imageLoader)
            mealDetailScreenBuilder(mealsViewModel, navController, imageLoader)
            profileScreenBuilder(navController, imageLoader)
            feedBackScreenBuilder(navController, imageLoader)
            helpAndSupportBuilder(navController, imageLoader)
            historyScreenBuilder(navController, imageLoader)
            orderScreenBuilder(navController, imageLoader)
        }
    )
}


fun NavGraphBuilder.orderScreenBuilder(navController: NavHostController, imageLoader: ImageLoader) {
//    composable(route = Screen.OrderScreen.route)
//    composable()
}

fun NavGraphBuilder.historyScreenBuilder(navController: NavHostController, imageLoader: ImageLoader) {
    composable(
        route = Screen.HistoryScreen.route
    ){
        HistoryScreen()
    }
}


fun NavGraphBuilder.mealDetailScreenBuilder(
    mealsViewModel: MealsViewModel,
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
         route = Screen.MealDetailScreen.route
    ) {
        MealDetailScreen(
            mealsViewModel = mealsViewModel,
            imageLoader = imageLoader,
            backClicked = {
                navController.navigate(Screen.MainScreen.route){
                    popUpTo(Screen.MainScreen.route){
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun NavGraphBuilder.helpAndSupportBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.HelpAndSupportScreen.route
    ) {
        HelpAndSupportScreen()
    }
}

fun NavGraphBuilder.feedBackScreenBuilder(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    composable(
        route = Screen.FeedbackScreen.route
    ) {
       FeedbackScreen {

       }
    }
}

fun NavGraphBuilder.profileScreenBuilder(
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
            ProfileScreen {

            }
        }
    }
}


@ExperimentalMaterialApi
fun NavGraphBuilder.mainScreenBuilder(
    mealsViewModel: MealsViewModel,
    navController: NavHostController,
    bottomNavController: NavHostController,
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
            mealsViewModel,
            imageLoader,
            bottomNavController,
            createRouter { route ->
                navController.navigate(route) {
                    launchSingleTop = true
                    popUpTo(Screen.MainScreen.route){
                    }
                }
            }
        )
    }
}

fun NavGraphBuilder.loginBuilder(
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

fun NavGraphBuilder.splashScreenBuilder(
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