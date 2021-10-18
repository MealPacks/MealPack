package `in`.mealpack.util

sealed class MealsUiState{
    object Loading : MealsUiState()
    data class Error(val msg:String) : MealsUiState()
    object Success : MealsUiState()
    object Empty : MealsUiState()
}
