package `in`.mealpack.meal_data

import `in`.mealpack.meal_data.modelDto.MealsDto
import `in`.mealpack.meal_data.modelDto.MealsDtoMapper
import `in`.mealpack.meal_domain.model.Meals
import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MealsRepositoryImpl @Inject constructor(
    val firestoreDb: FirebaseFirestore,
    val mealsDtoMapper: MealsDtoMapper
) : MealsRepository {

    override suspend fun getAllMeals(): Flow<List<Meals>> = callbackFlow {

        var mealsCollection: CollectionReference? = null
        try {
            mealsCollection = firestoreDb.collection("meals-dishes")
        } catch (e: Throwable) {
            close(e)
        }

        lateinit var mealsList: List<Meals>
        val subscription = mealsCollection?.addSnapshotListener { snapshot, exception ->

            if (snapshot == null && exception != null) {
                Log.e("meal-dishesException", "Exception when querying posts $exception")
                return@addSnapshotListener
            }
            try {
                val mealsDtoList = snapshot?.toObjects(MealsDto::class.java)
                Log.d("Meals-Dishes", "$mealsDtoList")

                mealsList = mealsDtoList!!.map {
                    mealsDtoMapper.mapFromNetworkToDomain(it)
                }
                Log.d("Meals-Dishes meals", "$mealsList")

                trySend(mealsList)
            } catch (e: Throwable) {
                /* no-op */
            }
        }
        awaitClose { subscription?.remove() }
    }

    override suspend fun getMealsDetail(id: String): Flow<Meals> = callbackFlow {
        getAllMeals().collect { it ->
            val meal = it.find {
                id == it.mealId
            }
            meal?.let {
                trySend(meal)
            }
        }
    }

    override suspend fun filterMeals(filter: String): Flow<List<Meals>> = callbackFlow {
        getAllMeals().collect { it ->
            val filteredMeals = it.filter {
                filter.lowercase().trim() == it.mealId.lowercase().trim()
            }
            if (filteredMeals.isEmpty()){
                trySend(it)
            }
            trySend(filteredMeals)
        }
    }


}