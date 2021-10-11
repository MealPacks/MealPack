package `in`.mealpack.user_domain

import java.sql.Timestamp

data class User(
    val userid: String,
    val name: String,
    val email: String,
    val phone: String,
    val photo: String,
    val address: Address?,
    val location: Location?,
)


