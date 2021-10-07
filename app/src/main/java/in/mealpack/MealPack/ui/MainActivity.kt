package `in`.mealpack.MealPack

import `in`.mealpack.MealPack.ui.Login.LoginScreen
import `in`.mealpack.MealPack.ui.theme.MealPackTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser

        setContent {
            MealPackTheme {
                LoginScreen(currentUser = currentUser)

            }
        }
    }


}

@Composable
fun BlankScreen(
    currentUser: FirebaseUser
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealPackTheme {

    }
}