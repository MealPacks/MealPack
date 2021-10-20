package `in`.mealpack.meal_data

import `in`.mealpack.meal_domain.model.Meals
import kotlinx.coroutines.flow.Flow

interface MealsRepository {

    suspend fun getAllMeals(): Flow<List<Meals>>

    suspend fun getMealsDetail(id: String): Flow<Meals>

     suspend fun filterMeals(filter: String): Flow<List<Meals>>


}