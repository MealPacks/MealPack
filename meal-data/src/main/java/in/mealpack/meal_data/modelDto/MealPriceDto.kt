package `in`.mealpack.meal_data.modelDto

import `in`.mealpack.meal_domain.model.PriceDetail


data class MealPriceDto(
    val plan1: PriceDetail,
    val plan2: PriceDetail,
    val plan3: PriceDetail,
    var plan4: PriceDetail = PriceDetail("","",0f),
    var plan5: PriceDetail = PriceDetail("","",0f),
    var plan6: PriceDetail = PriceDetail("","",0f),
    var plan7: PriceDetail = PriceDetail("","",0f),
    var plan8: PriceDetail = PriceDetail("","",0f),
    var plan9: PriceDetail = PriceDetail("","",0f),
    var plan10: PriceDetail = PriceDetail("","",0f),
)
