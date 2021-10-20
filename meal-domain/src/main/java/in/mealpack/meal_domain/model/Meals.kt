package `in`.mealpack.meal_domain.model

import `in`.mealpack.meal_domain.MealCovered


data class Meals(
    val mealId: String="",
    val category: String="",
    val mealName: String="",
    val mealPhoto: String="",
    val plan: PlanVariance= PlanVariance(),
    val desc: String="",
    val extraDesc: String="",
    val mealCovered: List<Boolean> = listOf(false,false,false),
    val mealPrice: MealPrice= MealPrice(),
    val deliveryTimings: DeliveryTimings= DeliveryTimings(),
    val generallyIncludes: GenerallyIncludes = GenerallyIncludes()
)