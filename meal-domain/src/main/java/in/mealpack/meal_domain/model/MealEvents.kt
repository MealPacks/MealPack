package `in`.mealpack.meal_domain.model

sealed class MealEvents<T>{
    class Loading<T>:MealEvents<T>()
    data class Success<T>(val data : List<Meals>):MealEvents<T>()
    class Empty<T>:MealEvents<T>()
}
