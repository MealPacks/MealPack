package `in`.mealpack.user_data

import `in`.mealpack.user_domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserManager @Inject constructor(private val userRepository: UserRepository) {

    private val _currentUser : MutableStateFlow<User> = MutableStateFlow(User())

    val currentUser : StateFlow<User> = _currentUser

    suspend fun getUserFromNetwork(userId :String){
        val user = userRepository.getCurrentUser(userId)
        _currentUser.value = user
    }

}