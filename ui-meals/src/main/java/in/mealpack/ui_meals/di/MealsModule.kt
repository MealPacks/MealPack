package `in`.mealpack.ui_meals.di

import `in`.mealpack.meal_data.MealsRepository
import `in`.mealpack.meal_data.MealsRepositoryImpl
import `in`.mealpack.meal_data.modelDto.MealsDtoMapper
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MealsModule {
    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun providesMealsRepository(
        firestoreDb: FirebaseFirestore,
        mealNetworkMapper: MealsDtoMapper
    ): MealsRepository {
        return MealsRepositoryImpl(firestoreDb,mealNetworkMapper)
    }
}