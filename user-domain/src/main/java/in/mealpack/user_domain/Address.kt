package `in`.mealpack.user_domain

data class Address(
    val line1:String,
    val line2:String,
    val line3:String,
    val city:String,
    val state:String,
    val country:String,
    val pincode:Int
)
