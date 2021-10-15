package `in`.mealpack.meal_data

import `in`.mealpack.meal_domain.model.Meals

interface MealsRepositoryItfc {

    suspend fun getAllMealsDto(): List<Meals>

}