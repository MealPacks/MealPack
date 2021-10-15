package `in`.mealpack.user_data

import `in`.mealpack.user_data.dto_models.UserDto
import `in`.mealpack.user_domain.User
import android.util.Log
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val firestoreDb: FirebaseFirestore,
    private val userNetworkMapper: UserNetworkMapper
) : UserRepositoryItfc {

    override suspend fun setUserToDb(user: User) {
        val userDto = userNetworkMapper.mapFromDomainToNetwork(user)
        userDto.timestamp = Timestamp.now()

        firestoreDb.collection("users").document(user.userid).set(
            userDto, SetOptions.merge()
        )
    }

    fun getCurrentUser(userId: String): User {
        var user = User()
        firestoreDb.collection("users").document(userId)
            .addSnapshotListener { snapshot, excepiton ->
                if (snapshot == null && excepiton != null) {
                    Log.e("UserNotFound", "Exception when querying users $excepiton")
                    return@addSnapshotListener
                }
                val userDto = snapshot?.toObject(UserDto::class.java)
                user = userNetworkMapper.mapFromNetworkToDomain(userDto!!)
            }
        return user
    }
}