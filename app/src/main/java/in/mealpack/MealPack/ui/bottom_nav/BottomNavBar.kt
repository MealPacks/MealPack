package `in`.mealpack.MealPack.ui.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBar(
    val id:String,
    val title:String,
    val icon:ImageVector
){

    object Meals:BottomNavBar("Meals","Meals", Icons.Outlined.Home)
    object Menu:BottomNavBar("Menu","Menu", Icons.Outlined.Menu)
    object MealPlans:BottomNavBar("MealPlans","MealPlans", Icons.Outlined.DateRange)

    object Items{
        val list = listOf(
            Meals,Menu,MealPlans
        )
    }

}