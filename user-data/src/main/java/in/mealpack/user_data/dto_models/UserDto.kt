package `in`.mealpack.user_data.dto_models

import java.sql.Timestamp


data class UserDto(
    val userid: String,
    val name: String,
    val email: String,
    val password: String?,
    val phone: String,
    val addressDto: AddressDto?,
    val locationDto: LocationDto?,
    val timestamp: Timestamp?,
    val photo: String
)

