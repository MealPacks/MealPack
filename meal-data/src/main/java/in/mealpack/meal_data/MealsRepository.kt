package `in`.mealpack.meal_data

import `in`.mealpack.meal_domain.model.Meals
import kotlinx.coroutines.flow.Flow

interface MealsRepository {

    fun getAllMeals(): Flow<List<Meals>>

    fun getMealsDetail(id: String): Flow<Meals>

    fun filterMeals(filter: String): Flow<List<Meals>>


}