package `in`.mealpack.ui_login.ui

import `in`.mealpack.core.LoadingState
import `in`.mealpack.user_data.UserRepository
import `in`.mealpack.user_domain.User
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val userRepository: UserRepository
) : ViewModel() {



    val loadingState = MutableStateFlow(LoadingState.IDLE)
    val loggedInUser = MutableLiveData<User>()
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

            val firebaseUser = Firebase.auth.currentUser

            val user = User(
                firebaseUser?.uid.toString(),
                firebaseUser?.displayName.toString(),
                firebaseUser?.email.toString(),
                firebaseUser?.phoneNumber.toString(),
                firebaseUser?.photoUrl.toString()
            )
            userRepository.setUserToDb(user)

            loggedInUser.value = user

            enabled.value = true

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