package `in`.mealpack.ui_meals.meals

import NetworkResult
import `in`.mealpack.meal_data.MealsRepository
import `in`.mealpack.meal_domain.model.Meals
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(

) : ViewModel() {

//    private val _allMeals: MutableStateFlow<NetworkResult<List<Meals>>> =
//        MutableStateFlow()

//    val allMeals = _allMeals


    fun getAllMeals() = viewModelScope.launch {
        try {
        } catch (e: Exception) {

        }
    }

}