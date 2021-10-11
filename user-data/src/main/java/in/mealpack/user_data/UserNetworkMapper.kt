package `in`.mealpack.user_data

import `in`.mealpack.core.domain.DtoDomainMapper
import `in`.mealpack.user_data.dto_models.AddressDto
import `in`.mealpack.user_data.dto_models.LocationDto
import `in`.mealpack.user_data.dto_models.UserDto
import `in`.mealpack.user_domain.Address
import `in`.mealpack.user_domain.Location
import `in`.mealpack.user_domain.User

class UserNetworkMapper : DtoDomainMapper<UserDto, User> {
    override fun mapFromNetworkToDomain(networkDto: UserDto): User {
            return User(
                userid = networkDto.userid,
                name = networkDto.name,
                email = networkDto.email,
                phone = networkDto.phone,
                address = Address(
                    networkDto.addressDto?.line1,
                    networkDto.addressDto?.line2,
                    networkDto.addressDto?.line3,
                    networkDto.addressDto?.city,
                    networkDto.addressDto?.city,
                    networkDto.addressDto?.state,
                    networkDto.addressDto?.country
                ),
                location = Location(
                    networkDto.locationDto?.latitude,
                    networkDto.locationDto?.longitude
                ),
                photo = networkDto.photo
            )
    }

    override fun mapFromDomainToNetwork(user: User): UserDto {
        return UserDto(
            userid = user.userid,
            name = user.name,
            email = user.email,
            phone = user.phone,
            addressDto = AddressDto(
                user.address?.line1,
                user.address?.line2,
                user.address?.line3,
                user.address?.city,
                user.address?.city,
                user.address?.state,
                user.address?.country
            ),
            locationDto = LocationDto(
                user.location?.latitude,
                user.location?.longitude
            ),
            password = null,
            timestamp = null,
            photo = user.photo
        )
    }



}