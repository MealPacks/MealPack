package `in`.mealpack.user_data

import `in`.mealpack.core.DtoDomainMapper
import `in`.mealpack.user_data.dto_models.AddressDto
import `in`.mealpack.user_data.dto_models.LocationDto
import `in`.mealpack.user_data.dto_models.UserDto
import `in`.mealpack.user_domain.Address
import `in`.mealpack.user_domain.Location
import `in`.mealpack.user_domain.User
import javax.inject.Inject

class UserNetworkMapper @Inject constructor() : DtoDomainMapper<UserDto, User> {
    override fun mapFromNetworkToDomain(networkDto: UserDto): User {
            return User(
                userid = networkDto.userid,
                name = networkDto.name,
                email = networkDto.email,
                phone = networkDto.phone,
                address = Address(
                    networkDto.address.line1,
                    networkDto.address.line2,
                    networkDto.address.line3,
                    networkDto.address.city,
                    networkDto.address.state,
                    networkDto.address.country,
                    networkDto.address.pincode
                ),
                location = Location(
                    networkDto.location.latitude,
                    networkDto.location.longitude
                ),
                photo = networkDto.photo
            )
    }

    override fun mapFromDomainToNetwork(domain: User): UserDto {
        return UserDto(
            userid = domain.userid,
            name = domain.name,
            email = domain.email,
            phone = domain.phone,
            address = AddressDto(
                domain.address.line1,
                domain.address.line2,
                domain.address.line3,
                domain.address.city,
                domain.address.state,
                domain.address.country,
                domain.address.pincode
            ),
            location = LocationDto(
                domain.location.latitude,
                domain.location.longitude
            ),
            photo = domain.photo
        )
    }



}