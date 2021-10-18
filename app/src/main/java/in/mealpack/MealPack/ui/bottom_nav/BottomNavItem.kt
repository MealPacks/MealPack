package `in`.mealpack.MealPack.ui.bottom_nav

import `in`.mealpack.MealPack.R
import androidx.annotation.DrawableRes

const val MEALS_PLAN_KEY ="meals_plan"
const val MENU_KEY ="menu"
const val MY_MEALS_PLANS_KEY ="my_meals_plan"

sealed class BottomNavItem(
    val title:String,
    val route: String,
    val routesIncluded: List<String>,
    @DrawableRes val icon: Int
) {

    object Menu : BottomNavItem("Menu",MENU_KEY, emptyList(), R.drawable.ic_menu)
    object MealsPlan : BottomNavItem("Meals",MEALS_PLAN_KEY, emptyList(), R.drawable.ic_meal_plan)
    object MyMealsPlans : BottomNavItem("My Plans",MY_MEALS_PLANS_KEY, emptyList(), R.drawable.ic_my_meal_plan)

    companion object Items {
        val list = listOf(
            Menu,MealsPlan,MyMealsPlans
        )
    }

}