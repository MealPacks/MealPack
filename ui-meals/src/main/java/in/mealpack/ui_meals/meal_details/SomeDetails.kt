package `in`.mealpack.ui_meals.meal_details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SomeDetails(
    modifier: Modifier = Modifier,
    someDetail: String
) {
    Text(
        modifier = modifier,
        text = someDetail
    )
}
