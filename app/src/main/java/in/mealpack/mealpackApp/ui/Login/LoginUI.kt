package `in`.mealpack.mealpackApp.ui.Login

import `in`.mealpack.mealpackApp.R
import `in`.mealpack.mealpackApp.ui.theme.MealPackTheme
import `in`.mealpack.mealpackApp.util.LoadingState
import `in`.mealpack.mealpack_testing_new_things.viewmodel.SignInGoogleViewModel
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginUi(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    signInViewModel: SignInGoogleViewModel,
    onClickGoogleLogin: () -> Unit,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    loadingText: String = "loading...",
    backgroundColor: Color = MaterialTheme.colors.surface,

    ) {

    val state by signInViewModel.loadingState.collectAsState()

    Box(
        modifier = modifier
            .padding(start = 32.dp)
            .clip(RoundedCornerShape(topStart = 200.dp))
            .background(MaterialTheme.colors.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_img),
                contentDescription = "app img",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
            )
            Text(
                text = "Meal Packs",
                fontSize = 32.sp
            )
            Button(
                onClick = {
                    onClickGoogleLogin()
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Unspecified,
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = if (state.status== LoadingState.Status.LOADING) loadingText
                    else "Continue with Google",
                    color = Color.Black,
                    fontSize = 20.sp
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
    }
}


@Preview
@Composable
fun ShowLoginUi() {
    MealPackTheme {
        LoginUi(signInViewModel = viewModel(), onClickGoogleLogin = { /*TODO*/ })
    }
}