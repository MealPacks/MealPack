package `in`.mealpack.ui_login.ui

import `in`.mealpack.core.domain.LoadingState
import `in`.mealpack.user_data.SetUserDtoToDbImpl
import `in`.mealpack.user_domain.User
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val setUserDto: SetUserDtoToDbImpl
) : ViewModel() {

    val loadingState = MutableStateFlow(LoadingState.IDLE)
    val enabled = MutableStateFlow(true)


    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        try {
            loadingState.emit(LoadingState.LOADING)
            Firebase.auth.signInWithEmailAndPassword(email, password).await()
            loadingState.emit(LoadingState.LOADED)
        } catch (e: Exception) {
            loadingState.emit(LoadingState.error(e.localizedMessage))
        }
    }

    fun signWithCredential(credential: AuthCredential) = viewModelScope.launch {
        try {
            loadingState.emit(LoadingState.LOADING)
            Firebase.auth.signInWithCredential(credential).await()
            loadingState.emit(LoadingState.LOADED)
        } catch (e: Exception) {
            loadingState.emit(LoadingState.error(e.localizedMessage))
        }
    }

    fun signWithCredential(task: Task<GoogleSignInAccount>) = viewModelScope.launch {
        try {
            enabled.value = false
            val account = task.getResult(ApiException::class.java)!!
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            loadingState.emit(LoadingState.LOADING)
            Firebase.auth.signInWithCredential(credential).await()
            enabled.value = true

            val user = User(
                FirebaseAuth.getInstance().currentUser?.uid.toString(),
                FirebaseAuth.getInstance().currentUser?.displayName.toString(),
                FirebaseAuth.getInstance().currentUser?.email.toString(),
                FirebaseAuth.getInstance().currentUser?.phoneNumber.toString(),
                FirebaseAuth.getInstance().currentUser?.photoUrl.toString(),
                null,
                null
            )
            setUserDto.setUserDtoToDb(user)

            loadingState.emit(LoadingState.LOADED)
        } catch (e: ApiException) {
            loadingState.emit(LoadingState.error(e.localizedMessage))
            Log.w("Login", "Google sign in failed", e)
        }
    }

    fun getGso(token: String): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(token)
            .requestEmail()
            .requestProfile()
            .build()
    }
}