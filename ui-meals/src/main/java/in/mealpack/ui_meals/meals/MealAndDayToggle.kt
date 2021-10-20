package `in`.mealpack.ui_meals.meals

import `in`.mealpack.ui_meals.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MealAndDayToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkedText: String,
    unCheckedText: String,
    modifier: Modifier = Modifier

) {

    Column(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .clickable {
            onCheckedChange(!checked)
        }
        .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = if (checked) checkedText else unCheckedText)
        IconToggleButton(
            checked = checked,
            onCheckedChange = { onCheckedChange(!checked) }
        ) {
            Icon(
                painter = painterResource(
                    id =
                    if (checked) (R.drawable.ic_toggle_left)
                    else (R.drawable.ic_toggle_right)
                ),
                contentDescription = "togglebutton",
                tint = Color.Unspecified
            )
        }
    }

}