package `in`.mealpack.meal_data.modelDto

import `in`.mealpack.meal_domain.MealCovered
import `in`.mealpack.meal_domain.model.DeliveryTimings
import `in`.mealpack.meal_domain.model.GenerallyIncludes
import `in`.mealpack.meal_domain.model.PlanVariance


data class MealsDto(
    val mealId: String = "",
    val mealName: String = "",
    val category: String = "",
    val mealPhoto: String = "",
    val plan: PlanVariance = PlanVariance(),
    val desc: String = "",
    val extraDesc: String = "",
    val mealCovered: List<Boolean> = listOf(false,false,false),
    val mealPrice: MealPriceDto = MealPriceDto(),
    val deliveryTimings: DeliveryTimings = DeliveryTimings("","",""),
    val generallyIncludes: GenerallyIncludes = GenerallyIncludes("","","","")
)
