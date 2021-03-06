package `in`.mealpack.MealPack.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

//private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200
//)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = OrangeAccent,
    background= BackgroundGrey,
    onBackground = TextBlack,
    onPrimary = TextWhite,
    surface = CardWhite,
    onSurface = Black,
    primaryVariant = WhiteButton


    /* Other default colors to override
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MealPackTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit) {

//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}