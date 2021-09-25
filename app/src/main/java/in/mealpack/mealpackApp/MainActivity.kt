package `in`.mealpack.mealpackApp

import `in`.mealpack.mealpackApp.ui.Login.LoginUi
import `in`.mealpack.mealpackApp.ui.theme.MealPackTheme
import `in`.mealpack.mealpack_testing_new_things.viewmodel.SignInGoogleViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

var PACKAGE_NAME: String? = null

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val context = LocalContext.current

                    val signInViewModel: SignInGoogleViewModel = viewModel()

                    val token = stringResource(R.string.default_web_client_id)

                    val authResultLauncher =
                        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
                            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                            try {
                                val account = task.getResult(ApiException::class.java)!!
                                val credential =
                                    GoogleAuthProvider.getCredential(account.idToken!!, null)
                                signInViewModel.signWithCredential(credential)
                            } catch (e: ApiException) {
                                Log.w("Login", "Google sign in failed", e)
                            }
                        }

                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.login_bg),
                            contentDescription = "Login Bg",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        LoginUi(
                            modifier = Modifier
                                .height(500.dp)
                                .align(Alignment.BottomCenter),
                            onClickGoogleLogin = {
                                val gso =
                                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                        .requestIdToken(token)
                                        .requestEmail()
                                        .build()

                                val googleSignInClient = GoogleSignIn.getClient(context, gso)
                                authResultLauncher.launch(googleSignInClient.signInIntent)
                            },
                            signInViewModel = signInViewModel
                        )
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealPackTheme {

    }
}