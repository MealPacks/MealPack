package `in`.mealpack.ui_login.di

import `in`.mealpack.user_data.UserNetworkMapper
import `in`.mealpack.user_data.UserRepository
import `in`.mealpack.user_data.UserRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UserModule {
    @Singleton
    @Provides
    fun providesUserRepository(
        firestoreDb:FirebaseFirestore,
        userNetworkMapper: UserNetworkMapper
    ): UserRepository {
        return UserRepositoryImpl(firestoreDb,userNetworkMapper)
    }
}