package `in`.mealpack.user_data

import `in`.mealpack.user_domain.User

interface SetUserDtoToDb {
    suspend fun setUserDtoToDb(user: User)
}