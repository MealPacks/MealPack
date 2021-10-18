package `in`.mealpack.MealPack.ui.Login

import `in`.mealpack.core.LoadingState
import `in`.mealpack.ui_login.R
import `in`.mealpack.ui_login.ui.LoginViewModel
import `in`.mealpack.user_domain.User
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

@Composable
fun LoginUi(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    loadingText: String = "loading...",
    backgroundColor: Color = MaterialTheme.colors.surface,
    onSuccessUserAuth: (User) -> Unit

) {

    val state by loginViewModel.loadingState.collectAsState()

    val enabled by loginViewModel.enabled.collectAsState()

    val context = LocalContext.current

    val token = stringResource(R.string.default_web_client_id)

    val authResultLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                loginViewModel.signWithCredential(task)
            } catch (e: ApiException) {
                Log.w("Login", "Google sign in failed", e)
            }
        }

    Column(
        modifier = modifier
            .padding(start = 38.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 200.dp))
            .background(MaterialTheme.colors.primary)
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_img),
            contentDescription = "app img",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
        )
        Text(
            text = "Meal Packs",
            fontSize = 32.sp
        )
        GoogleButton(
            state = state,
            loadingText = loadingText,
            progressIndicatorColor = progressIndicatorColor,
            enabled = enabled
        ) {
            val gso = loginViewModel.getGso(token)
            val googleSignInClient = GoogleSignIn.getClient(context, gso)
            authResultLauncher.launch(googleSignInClient.signInIntent)
        }
        if (state == LoadingState.LOADED) {
            val loginUser = loginViewModel.loggedInUser.observeAsState()
            loginUser.value?.let(onSuccessUserAuth)
        }
    }
}

@Composable
fun GoogleButton(
    state: LoadingState,
    buttonText: String = "Continue with Google",
    loadingText: String = "loading...",
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onclick: () -> Unit
) {
    Button(
        onClick = onclick,
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Unspecified,
            backgroundColor = MaterialTheme.colors.primaryVariant
        ),
        modifier = modifier
            .padding(6.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clip(RoundedCornerShape(30.dp))
            .padding(bottom = 4.dp, end = 4.dp)
            .zIndex(20f),
//            .background(MaterialTheme.colors.primaryVariant),
        elevation = ButtonDefaults.elevation(20.dp),
        enabled = enabled
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "Google Icon",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = if (state.status == LoadingState.Status.LOADING) loadingText
            else buttonText,
            color = Color.Black,
            fontSize = 16.sp
        )

        if (state.status == LoadingState.Status.LOADING) {
            Spacer(modifier = Modifier.width(16.dp))
            CircularProgressIndicator(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp),
                strokeWidth = 2.dp,
                color = progressIndicatorColor
            )

        }

    }
}

@Preview
@Composable
fun LoginUiPreview() {
    LoginUi(loginViewModel = hiltViewModel(), onSuccessUserAuth = {})
}


