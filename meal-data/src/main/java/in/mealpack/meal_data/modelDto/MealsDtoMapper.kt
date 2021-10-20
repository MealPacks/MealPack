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
            category = networkDto.category,
            mealPhoto = networkDto.mealPhoto,
            plan = networkDto.plan,
            desc = networkDto.desc,
            extraDesc = networkDto.extraDesc,
            mealCovered = networkDto.mealCovered,
            mealPrice = MealPrice(
                networkDto.mealPrice.plan1,
                networkDto.mealPrice.plan2,
                networkDto.mealPrice.plan3
//                networkDto.mealPrice.plan4,
//                networkDto.mealPrice.plan5,
//                networkDto.mealPrice.plan6,
//                networkDto.mealPrice.plan7,
            ),
            deliveryTimings = networkDto.deliveryTimings,
            generallyIncludes = networkDto.generallyIncludes
        )
    }

    //No setting of meal plans are done from the client side so not needed till now
    override fun mapFromDomainToNetwork(domain: Meals): MealsDto {
        return MealsDto(
            mealId = domain.mealId,
            mealName = domain.mealName,
            category = domain.category,
            mealPhoto = domain.mealPhoto,
            plan = domain.plan,
            desc = domain.desc,
            extraDesc = domain.extraDesc,
            mealCovered = domain.mealCovered,
            mealPrice = MealPriceDto(
                domain.mealPrice.plan1,
                domain.mealPrice.plan2,
                domain.mealPrice.plan3,
//                domain.mealPrice.plan4,
//                domain.mealPrice.plan5,
//                domain.mealPrice.plan6,
//                domain.mealPrice.plan7,
            ),
            deliveryTimings = domain.deliveryTimings,
            generallyIncludes = domain.generallyIncludes

        )
    }
}