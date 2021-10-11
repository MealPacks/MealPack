package `in`.mealpack.core.domain

sealed class DietType() {
    object Veg : DietType()
    object NonVeg : DietType()
}
