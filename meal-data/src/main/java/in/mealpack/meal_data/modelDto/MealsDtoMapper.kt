package `in`.mealpack.meal_data.modelDto

import `in`.mealpack.core.DtoDomainMapper
import `in`.mealpack.meal_domain.model.MealPrice
import `in`.mealpack.meal_domain.model.Meals
import javax.inject.Inject

class MealsDtoMapper @Inject constructor() : DtoDomainMapper<MealsDto, Meals> {
    override fun mapFromNetworkToDomain(networkDto: MealsDto): Meals {
        return Meals(
            mealId = networkDto.mealId,
            mealName = networkDto.mealName,
            photo = networkDto.photo,
            dietType = networkDto.dietType,
            plan = networkDto.plan,
            desc = networkDto.desc,
            mealsCovered = networkDto.mealsCovered,
            mealPrice = MealPrice(
                networkDto.mealPrice.plan1,
                networkDto.mealPrice.plan2,
                networkDto.mealPrice.plan3,
                networkDto.mealPrice.plan4,
                networkDto.mealPrice.plan5,
                networkDto.mealPrice.plan6,
                networkDto.mealPrice.plan7,
            )
        )
    }

    //No setting of meal plans are done from the client side so not needed till now
    override fun mapFromDomainToNetwork(domain: Meals): MealsDto {
        return MealsDto(
            mealId = domain.mealId,
            mealName = domain.mealName,
            photo = domain.photo,
            dietType = domain.dietType,
            plan = domain.plan,
            desc = domain.desc,
            mealsCovered = domain.mealsCovered,
            mealPrice = MealPriceDto(
                domain.mealPrice.plan1,
                domain.mealPrice.plan2,
                domain.mealPrice.plan3,
                domain.mealPrice.plan4,
                domain.mealPrice.plan5,
                domain.mealPrice.plan6,
                domain.mealPrice.plan7,
            )
        )
    }
}