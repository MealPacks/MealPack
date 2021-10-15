package `in`.mealpack.user_data.dto_models

import com.google.firebase.Timestamp
import java.util.*


data class UserDto(
    val userid: String="",
    val name: String="",
    val email: String="",
    val password: String?="",
    val phone: String="",
    val address: AddressDto = AddressDto("","","","","","",0),
    val location: LocationDto,
    var timestamp :Timestamp = Timestamp(0,0),
    val photo: String
)

