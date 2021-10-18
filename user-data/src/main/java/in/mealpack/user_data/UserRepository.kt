package `in`.mealpack.user_data

import `in`.mealpack.user_domain.User

interface UserRepository {
    suspend fun setUserToDb(user: User)

    suspend fun getCurrentUser(userId: String): User
}