package `in`.mealpack.meal_domain.model


data class MealPrice(
    val plan1: PriceDetail= PriceDetail("","",0f),
    val plan2: PriceDetail= PriceDetail("","",0f),
    val plan3: PriceDetail= PriceDetail("","",0f),
    val plan4: PriceDetail= PriceDetail("","",0f),
    val plan5: PriceDetail= PriceDetail("","",0f),
    val plan6: PriceDetail= PriceDetail("","",0f),
    val plan7: PriceDetail= PriceDetail("","",0f),
)
