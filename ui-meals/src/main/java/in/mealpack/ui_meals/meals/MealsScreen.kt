package `in`.mealpack.mealpack_testing_new_things.ui.components.meals

import `in`.mealpack.core.DietType
import `in`.mealpack.meal_domain.MealCardData
import `in`.mealpack.meal_domain.MealsCovered
import `in`.mealpack.ui_meals.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MealScreen(
    onMealCardClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ) {
        var mealChecked by remember {
            mutableStateOf(false)
        }
        var timesADayChecked by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 36.dp, top = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            MealAndDayToggle(
                checked = mealChecked,
                onCheckedChange = {
                    mealChecked = it
                },
                checkedText = "Veg",
                unCheckedText = "Non-Veg"
            )

            MealAndDayToggle(
                checked = timesADayChecked,
                onCheckedChange = {
                    timesADayChecked = it
                },
                checkedText = "2 Times a Day",
                unCheckedText = "3 Times a Day"
            )


        }

        MealCards(
            mealCards = listOf(
                MealCardData(
                    mealId = "1",
                    mealName = "Heavy Meal Plan",
                    mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
                    imageUrl = "",
                    dietType = DietType.Veg,
                    mealsCovered = MealsCovered(true, true, true)
                ),
                MealCardData(
                    mealId = "1",
                    mealName = "Light Meal Plan",
                    mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
                    imageUrl = "",
                    dietType = DietType.Veg,
                    mealsCovered = MealsCovered(false, false, true)
                ),
                MealCardData(
                    mealId = "1",
                    mealName = "Light Meal Plan",
                    mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
                    imageUrl = "",
                    dietType = DietType.Veg,
                    mealsCovered = MealsCovered(true, true, true)
                ),
                MealCardData(
                    mealId = "1",
                    mealName = "Heavy Meal Plan",
                    mealDesc = "2 Roti, Choole, 1Bowl Rice, Dal, Poha, idli...",
                    imageUrl = "",
                    dietType = DietType.NonVeg,
                    mealsCovered = MealsCovered(false, true, true)
                )
            )
        ) {
            onMealCardClicked(it)
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun ShowMealScreen() {
    MealScreen {}
}