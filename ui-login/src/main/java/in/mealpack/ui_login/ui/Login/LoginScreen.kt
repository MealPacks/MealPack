package `in`.mealpack.MealPack.ui.Login

import `in`.mealpack.ui_login.ui.LoginViewModel
import `in`.mealpack.ui_login.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseUser

@Composable
fun LoginScreen(
    currentUser: FirebaseUser?
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val loginViewModel: LoginViewModel = viewModel()

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "Login Bg",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.TopEnd)
            ) {
                Text(text = "Skip")
            }
            LoginUi(
                modifier = Modifier
                    .height(500.dp)
                    .align(Alignment.BottomCenter),
                loginViewModel = loginViewModel,
                currentUser = currentUser
            )
        }
    }
}

