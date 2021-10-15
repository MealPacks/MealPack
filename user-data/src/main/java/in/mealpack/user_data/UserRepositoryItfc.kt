package `in`.mealpack.user_data

import `in`.mealpack.user_domain.User

interface UserRepositoryItfc {
    suspend fun setUserToDb(user: User)
}