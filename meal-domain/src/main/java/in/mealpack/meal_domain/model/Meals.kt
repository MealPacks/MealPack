package `in`.mealpack.meal_domain.model

import `in`.mealpack.meal_domain.MealsCovered

data class Meals(
    val mealId:String,
    val category: String,
    val mealName:String,
    val mealPhoto:String,
    val dietType: DietCategory,
    val plan:PlanVariance,
    val desc:String,
    val mealsCovered: MealsCovered,
    val mealPrice: MealPrice,
    val deliveryTimings: DeliveryTimings,
    val generallyIncludes: GenerallyIncludes
)
