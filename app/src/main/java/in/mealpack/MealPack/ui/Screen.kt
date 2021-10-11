package `in`.mealpack.MealPack.ui

sealed class Screen(
    val route:String
){
    object LoginScreen: Screen(route = "login_screen")
    object MealsScreen: Screen(route = "meals_screen")
    object MealsDetailsScreen: Screen(route = "meals_details_screen")
    object OptionsScreen: Screen(route = "options_screen")
    object MealPlansScreen: Screen(route = "meal_plan_screen")

}
