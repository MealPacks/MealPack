package `in`.mealpack.ui_login.di

import `in`.mealpack.user_data.SetUserDtoToDbImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SetUserDto {
    @Singleton
    @Provides
    fun providesSetUserDto(): SetUserDtoToDbImpl {
        val setUserDtoToDbImpl = SetUserDtoToDbImpl()
        return setUserDtoToDbImpl
    }

}