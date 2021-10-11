package `in`.mealpack.user_data

import `in`.mealpack.user_domain.User
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SetUserDtoToDbImpl : SetUserDtoToDb {
    override suspend fun setUserDtoToDb(user: User) {

        val userNetworkMapper= UserNetworkMapper()

        val userDto=userNetworkMapper.mapFromDomainToNetwork(user)
        val firestoreDb = Firebase.firestore

        firestoreDb.collection("users").document(user.userid).set(
            userDto, SetOptions.merge()
        )


    }
}