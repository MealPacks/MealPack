package `in`.mealpack.ui_meals.meals

import `in`.mealpack.core.LoadingState
import `in`.mealpack.meal_data.MealsRepository
import `in`.mealpack.meal_domain.model.Meals
import `in`.mealpack.util.MealsUiState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
/*
@HiltViewModel
class MealsViewModel @Inject constructor(
    val mealsRepository: MealsRepository
) : ViewModel() {

    private val _allMeals: MutableStateFlow<List<Meals>> =
        MutableStateFlow(listOf())

    val allMeals: StateFlow<List<Meals>> = _allMeals

    val uiState: MutableStateFlow<MealsUiState> = MutableStateFlow(MealsUiState.Empty)


    fun getAllMeals() = viewModelScope.launch {
        try {
            uiState.emit(MealsUiState.Loading)
            val mealsList = mealsRepository.getAllMeals()
            _allMeals.value = mealsList
            uiState.emit(MealsUiState.Success)
        } catch (e: Exception) {
            uiState.emit(MealsUiState.Error("$e"))
        }
    }

}

 */