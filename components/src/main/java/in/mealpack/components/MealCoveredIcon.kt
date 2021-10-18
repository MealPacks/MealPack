package `in`.mealpack.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MealCoveredIcon(
    modifier: Modifier = Modifier,
    isAvailable: Boolean,
    coveredMealName: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isAvailable) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tick_checked),
                contentDescription = coveredMealName,
                tint = Color.Green
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_cross_checked),
                contentDescription = coveredMealName,
                tint = Color.Red
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = coveredMealName,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview
@Composable
fun MealCoveredIconPreview() {
    MealCoveredIcon(isAvailable = true, coveredMealName = "veg")
}