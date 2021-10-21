package `in`.mealpack.MealPack.ui

import `in`.mealpack.MealPack.ui.SetUpNavGraph
import `in`.mealpack.MealPack.ui.theme.MealPackTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader


    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            MealPackTheme {
                SetUpNavGraph(navController, imageLoader)
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