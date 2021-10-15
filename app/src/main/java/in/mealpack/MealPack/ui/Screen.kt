package `in`.mealpack.MealPack.ui

const val USER_ID = "userId"

sealed class Screen(
    val route:String
){
    //SplashScreen
    object SplashScreen: Screen(route = "splash_screen")

    //Login
    object LoginScreen: Screen(route = "login_screen")

    // Meals
    object MealsScreen: Screen(route = "meals_screen?userId={$USER_ID}"){
        fun sendUserId(id : String):String{
            return "meals_screen?userId=$id"
        }

    }
    object OptionsScreen: Screen(route = "options_screen")
    object MealPlansScreen: Screen(route = "meal_plans_screen")
    object MealsDetailsScreen: Screen(route = "meal_details_screen")

    //Ordering

}
