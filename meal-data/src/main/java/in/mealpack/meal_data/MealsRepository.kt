package `in`.mealpack.meal_data

import `in`.mealpack.meal_data.modelDto.MealsDto
import `in`.mealpack.meal_data.modelDto.MealsDtoMapper
import `in`.mealpack.meal_domain.model.Meals
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MealsRepository @Inject constructor(
    val firestoreDb: FirebaseFirestore,
    val mealsDtoMapper: MealsDtoMapper
) : MealsRepositoryItfc {
    override suspend fun getAllMealsDto(): List<Meals> {

        lateinit var mealsDtoList: MutableList<MealsDto>
        firestoreDb.collection("meals-dishes")
            .addSnapshotListener { snapshot, excepiton ->

                if (snapshot == null && excepiton != null) {
                    Log.e("meal-dishesException","Exception when querying posts $excepiton")
                    return@addSnapshotListener
                }

                 mealsDtoList = snapshot?.toObjects(MealsDto::class.java) as MutableList<MealsDto>
            }
        val mealsList=mealsDtoList.map {
            mealsDtoMapper.mapFromNetworkToDomain(it)
        }
        return mealsList
    }


}