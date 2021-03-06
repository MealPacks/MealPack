package `in`.mealpack.MealPack.ui.Login

import `in`.mealpack.ui_login.R
import `in`.mealpack.ui_login.ui.LoginViewModel
import `in`.mealpack.user_domain.User
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onSuccessUserAuth: (User) -> Unit,
    onSkipClicked : ()-> Unit
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "Login Bg",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Button(
                onClick = {
                          onSkipClicked()
                },
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.TopEnd),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = Color.Unspecified
                )
            ) {
                Text(
                    text = "Skip",
                    color = Color.Gray
                )
            }
            LoginUi(
                modifier = Modifier
                    .height(500.dp)
                    .align(Alignment.BottomCenter),
                loginViewModel = loginViewModel,
                onSuccessUserAuth = {
                    onSuccessUserAuth(it)
                }
            )
        }
    }
}

