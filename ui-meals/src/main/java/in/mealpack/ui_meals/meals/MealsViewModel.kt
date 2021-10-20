package `in`.mealpack.ui_meals.meals

import `in`.mealpack.meal_data.MealsRepository
import `in`.mealpack.meal_domain.model.Meals
import `in`.mealpack.util.MealsUiState
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    val mealsRepository: MealsRepository
) : ViewModel() {

     private val _showChoosePlanPopUp : MutableStateFlow<Boolean>  = MutableStateFlow(false)
     val showChoosePlanPopUp : StateFlow<Boolean>  = _showChoosePlanPopUp

    private val _allMeals: MutableStateFlow<List<Meals>> = MutableStateFlow(listOf())
    val allMeals: StateFlow<List<Meals>> = _allMeals

    val uiState: MutableStateFlow<MealsUiState> = MutableStateFlow(MealsUiState.Empty)


    // TODO: 10/19/2021 create a mealState for integration with Meals instead of separate ui state
    private val _mealsDetail: MutableStateFlow<Meals> = MutableStateFlow(Meals())
    val mealsDetail: StateFlow<Meals> = _mealsDetail

    init {
        getAllMeals()
    }


    private fun getAllMeals() = viewModelScope.launch {
        try {
            uiState.emit(MealsUiState.Loading)
            mealsRepository.getAllMeals().collect {
                _allMeals.value = it
                Log.e("MealsVm", "$it")
            }
            uiState.emit(MealsUiState.Success)
        } catch (e: Exception) {
            uiState.emit(MealsUiState.Error("$e"))
        }
    }

    fun getMealsDetails(id: String) = viewModelScope.launch {

        try {
            uiState.emit(MealsUiState.Loading)
            mealsRepository.getMealsDetail(id).collect {
                _mealsDetail.value = it
                Log.e("MealsVmDetails", "$it")
            }
        } catch (e: Exception) {
            uiState.emit(MealsUiState.Error("$e"))
        }

    }

    fun filterMeals(filter:String) = viewModelScope.launch {
        try {
            uiState.emit(MealsUiState.Loading)
            mealsRepository.filterMeals(filter).collect{
                _allMeals.value = it
            }
        }catch (e:Exception){
            uiState.emit(MealsUiState.Error("$e"))
        }
    }

    fun changeShowChoosePlanState( state :Boolean){
        _showChoosePlanPopUp.value=state
    }


}

