package `in`.mealpack.meal_data.modelDto

import `in`.mealpack.meal_domain.MealsCovered
import `in`.mealpack.meal_domain.model.DeliveryTimings
import `in`.mealpack.meal_domain.model.DietCategory
import `in`.mealpack.meal_domain.model.GenerallyIncludes
import `in`.mealpack.meal_domain.model.PlanVariance


data class MealsDto(
    val mealId: String,
    val mealName: String,
    val category: String,
    val mealPhoto: String,
    val dietType: DietCategory,
    val plan: PlanVariance,
    val desc: String,
    val mealsCovered: MealsCovered,
    val mealPrice: MealPriceDto,
    val deliveryTimings: DeliveryTimings,
    val generallyIncludes: GenerallyIncludes

)
