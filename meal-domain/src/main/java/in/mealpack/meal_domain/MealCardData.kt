package `in`.mealpack.meal_domain

import `in`.mealpack.core.domain.DietType


data class MealCardData(
    val mealId:String,
    val imageUrl: String,
    var mealName: String,
    var mealDesc: String,
    val dietType: DietType,
    val mealsCovered: MealsCovered
)
