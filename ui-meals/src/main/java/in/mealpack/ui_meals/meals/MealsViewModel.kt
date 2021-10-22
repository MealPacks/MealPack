package `in`.mealpack.ui_meals.meals

import `in`.mealpack.core.states.FilterState
import `in`.mealpack.meal_data.MealsRepository
import `in`.mealpack.meal_domain.model.Meals
import `in`.mealpack.util.MealsUiState
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    private val mealsRepository: MealsRepository
) : ViewModel() {

    private val _showChoosePlanPopUp: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showChoosePlanPopUp: StateFlow<Boolean> = _showChoosePlanPopUp

    private val _allMeals: MutableStateFlow<List<Meals>> = MutableStateFlow(emptyList())

    private val _currentMealList: MutableStateFlow<List<Meals>> = _allMeals
    val currentMealList: StateFlow<List<Meals>> = _allMeals

    private val _uiState: MutableStateFlow<MealsUiState> = MutableStateFlow(MealsUiState.Empty)
    val uiState: StateFlow<MealsUiState> = _uiState

    private val _filteredList = mutableStateOf(FilterState())
    val filteredList: State<FilterState> = _filteredList


    // TODO: 10/19/2021 create a mealState for integration with Meals instead of separate ui state
    private val _mealsDetail: MutableStateFlow<Meals> = MutableStateFlow(Meals())
    val mealsDetail: StateFlow<Meals> = _mealsDetail

    init {
        getAllMeals()
        getFilters()
    }


    private fun getAllMeals() = viewModelScope.launch {
        try {
            _uiState.emit(MealsUiState.Loading)
            mealsRepository.getAllMeals().collect {
                _allMeals.value = it
                Log.e("MealsVm", "$it")
            }
            _uiState.emit(MealsUiState.Success)
        } catch (e: Exception) {
            _uiState.emit(MealsUiState.Error("$e"))
        }
    }

    fun getMealsDetails(id: String) = viewModelScope.launch {
        try {
            _uiState.emit(MealsUiState.Loading)
            mealsRepository.getMealsDetail(id).collect {
                _mealsDetail.value = it
                Log.e("MealsVmDetails", "$it")
            }
        } catch (e: Exception) {
            _uiState.emit(MealsUiState.Error("$e"))
        }

    }

    fun filterMeals(filter: String) = viewModelScope.launch {
        try {
            _uiState.emit(MealsUiState.Loading)

            mealsRepository.filterMeals(filter).collect {
                _currentMealList.value = it
                Log.d("filtered items", "$it")
            }
        } catch (e: Exception) {
            _uiState.emit(MealsUiState.Error("$e"))
        }
    }

    fun changeShowChoosePlanState(state: Boolean) {
        _showChoosePlanPopUp.value = state
    }

    private fun getFilters() = viewModelScope.launch {

        mealsRepository.getAllMeals().collect {

            val listOfFilters =
                it.filter {
                    it.category != ""
                }.map {
                    it.category.trim()
                }.distinct()


            val filters = mutableListOf<String>()

            filters.add("All")

            for (item in listOfFilters) {
                Log.d("Filteritem", item)
                filters.add(item)
            }

            Log.d("Filteritem", "$filters")
            Log.d("filtered items", "${_allMeals.value}")

            _filteredList.value = _filteredList.value.copy(
                filters = filters
            )


        }

    }

    fun changeCurrentFilterSelected(selectedFilter: String) = viewModelScope.launch {
        _filteredList.value = _filteredList.value.copy(
            selectedFilter = selectedFilter
        )
        Log.d("selectedFilter","${_filteredList.value.selectedFilter},${_filteredList.value.filters}")
    }

}

