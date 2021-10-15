package `in`.mealpack.user_domain

import java.sql.Timestamp

data class User(
    val userid: String="",
    val name: String="",
    val email: String="",
    val phone: String="",
    val photo: String="",
    val address: Address= Address("","","","","","",0),
    val location: Location=Location(0.0,0.0),
)


