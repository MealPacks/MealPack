package `in`.mealpack.meal_data

import `in`.mealpack.meal_domain.model.Meals

interface MealsRepository {

    suspend fun getAllMeals(): List<Meals>

}